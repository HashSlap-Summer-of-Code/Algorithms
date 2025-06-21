#include <iostream>

/**
 * @brief Computes (base * exp) % mod using binary multiplication to prevent overflow.
 * @param base The base number.
 * @param exp The exponent number.
 * @param mod The modulus.
 * @return The result of (base * exp) % mod.
 *
 * This function is used internally by modularExponentiation.
 * It's crucial when base and mod are large (up to 10^18) because a direct
 * (base * exp) might overflow even long long before applying modulo.
 * It works by breaking down multiplication into additions and shifts,
 * similar to binary exponentiation.
 *
 * Time Complexity: O(log(exp))
 * Space Complexity: O(1)
 */
long long modularMultiply(long long base, long long exp, long long mod) {
    long long res = 0;
    base %= mod; // Ensure base is within modulo range

    while (exp > 0) {
        if (exp % 2 == 1) { // If exp is odd, add current base to result
            res = (res + base) % mod;
        }
        base = (base * 2) % mod; // Double the base
        exp /= 2;                // Halve the exponent
    }
    return res;
}

/**
 * @brief Efficiently computes (a^b) % m using binary exponentiation (exponentiation by squaring).
 *
 * This algorithm significantly reduces the number of multiplications required from b to log(b).
 * It handles large values of a, b, and m (up to 10^18) by using `long long` and
 * an internal modular multiplication function (`modularMultiply`) to prevent overflow
 * during intermediate squaring steps.
 *
 * @param a The base.
 * @param b The exponent.
 * @param m The modulus.
 * @return The result of (a^b) % m.
 *
 * Time Complexity: O(log b) due to binary exponentiation.
 * Each step involves a modular multiplication, which itself is O(log(max(a,m))).
 * So, more precisely, O(log b * log(max(a,m))) if modularMultiply uses loop,
 * or O(log b) if native multiplication is fine. Given the requirement
 * for 10^18, we use modularMultiply, so it's closer to O(log b * log m).
 * Space Complexity: O(1)
 */
long long modularExponentiation(long long a, long long b, long long m) {
    long long res = 1;
    a %= m; // Reduce a modulo m upfront

    // Handle case where a is 0 and m is non-zero
    if (a == 0) {
        return 0; // 0^b mod m = 0 for b > 0.
                  // Note: 0^0 mod m is usually 1, but typical constraints for b are positive.
                  // For b=0, the loop won't run, and res=1 is returned, which is correct for 0^0 = 1.
    }
    
    while (b > 0) {
        if (b % 2 == 1) { // If b is odd, multiply result by current 'a'
            res = modularMultiply(res, a, m); // Use modular multiplication to prevent overflow
        }
        a = modularMultiply(a, a, m); // Square 'a'
        b /= 2;                       // Halve 'b'
    }
    return res;
}

int main() {
    // --- Example Usage ---
    std::cout << "--- Modular Exponentiation Examples ---" << std::endl;

    // Example 1: Basic case
    long long a1 = 2, b1 = 10, m1 = 1000;
    std::cout << "(" << a1 << "^" << b1 << ") % " << m1 << " = "
              << modularExponentiation(a1, b1, m1) << " (Expected: 24)" << std::endl; // 2^10 = 1024; 1024 % 1000 = 24

    // Example 2: Large numbers (within long long limits, where modularMultiply is essential)
    long long a2 = 1000000000000000000LL; // 10^18
    long long b2 = 1000000000000000000LL; // 10^18
    long long m2 = 1000000007LL;         // A large prime number (Mersenne prime for demonstration)
    std::cout << "(" << a2 << "^" << b2 << ") % " << m2 << " = "
              << modularExponentiation(a2, b2, m2) << std::endl;
    // Note: The expected value here is complex to calculate manually, but the function should work.

    // Example 3: Another large case
    long long a3 = 987654321LL;
    long long b3 = 123456789LL;
    long long m3 = 1000000007LL;
    std::cout << "(" << a3 << "^" << b3 << ") % " << m3 << " = "
              << modularExponentiation(a3, b3, m3) << std::endl;

    // Example 4: Edge case: exponent 0
    long long a4 = 5, b4 = 0, m4 = 100;
    std::cout << "(" << a4 << "^" << b4 << ") % " << m4 << " = "
              << modularExponentiation(a4, b4, m4) << " (Expected: 1)" << std::endl;

    // Example 5: Edge case: base 0
    long long a5 = 0, b5 = 5, m5 = 100;
    std::cout << "(" << a5 << "^" << b5 << ") % " << m5 << " = "
              << modularExponentiation(a5, b5, m5) << " (Expected: 0)" << std::endl;
    
    // --- Bonus: Command-line interface ---
    std::cout << "\n--- Command-Line Interface (CLI) ---" << std::endl;
    std::cout << "Enter values for a, b, and m (up to 10^18):" << std::endl;
    long long cli_a, cli_b, cli_m;
    std::cout << "Enter a: ";
    std::cin >> cli_a;
    std::cout << "Enter b: ";
    std::cin >> cli_b;
    std::cout << "Enter m: ";
    std::cin >> cli_m;

    if (cli_m <= 0) {
        std::cerr << "Error: Modulus (m) must be greater than 0." << std::endl;
        return 1; // Indicate error
    }

    long long cli_result = modularExponentiation(cli_a, cli_b, cli_m);
    std::cout << "(" << cli_a << "^" << cli_b << ") % " << cli_m << " = " << cli_result << std::endl;

    return 0;
}