# Modular Exponentiation

This directory contains an efficient implementation of the **Modular Exponentiation** algorithm (also known as binary exponentiation or exponentiation by squaring) in C++. This algorithm is fundamental in number theory and cryptography for computing large powers modulo a number.

---

## Algorithm Description

The problem is to compute $(a^b) \pmod m$ where `a`, `b`, and `m` can be very large integers (up to $10^{18}$). A direct computation of $a^b$ would quickly overflow standard data types, even for relatively small `b`, before the modulo operation can be applied. Iteratively multiplying `a` `b` times would be too slow if `b` is large.

**Binary Exponentiation** addresses these issues:

1.  **Efficiency (Time):** It reduces the number of multiplications from `b` to `log b`. It leverages the property that $a^b$ can be computed by repeatedly squaring `a` and multiplying into the result only when the corresponding bit in `b`'s binary representation is set.
    * If `b` is even, $a^b = (a^2)^{b/2}$.
    * If `b` is odd, $a^b = a \cdot (a^2)^{(b-1)/2}$.

2.  **Handling Large Values (Overflow):** The modulo operation `% m` is applied at every multiplication step. This keeps intermediate results small, preventing overflow.

### Special Consideration for $10^{18}$ Values

When `a` and `m` are both up to $10^{18}$, a direct multiplication like `(result * a)` or `(a * a)` could still overflow a `long long` before the modulo operation. For example, $(10^{18} \times 10^{18})$ results in $10^{36}$, which exceeds the `long long` limit ($\approx 9 \times 10^{18}$).

To combat this, an auxiliary function `modularMultiply(base, exp, mod)` is used. This function computes `(base * exp) % mod` using a technique similar to binary exponentiation but applied to multiplication (often called "peasant multiplication" or "binary multiplication"). It breaks down multiplication into a series of additions and shifts, ensuring that all intermediate sums remain within `long long` bounds after each modulo.

---

## Time and Space Complexity

* ### Time Complexity: O(log b * log m)
    * The binary exponentiation loop runs `log b` times (each iteration halves `b`).
    * Inside the loop, the `modularMultiply` function is called, which itself takes `log m` (or more precisely, `log(max(a, m))` or `log(max(intermediate_result, a))`) operations as it performs binary multiplication.
    * Therefore, the overall time complexity is a product of these two logarithmic factors.

* ### Space Complexity: O(1)
    * The algorithm uses a constant amount of extra space for a few variables (`res`, `a`, `b`, `m`, `base`, `exp`, `mod`). It does not allocate any data structures whose size depends on the input values `a`, `b`, or `m`.

---

## Usage and Examples

The `modular_exponentiation.cpp` file includes a `main` function with several illustrative examples and an optional command-line interface.

### How to Compile and Run (C++)

1.  Navigate to the `math/modular-exponentiation/` directory.
2.  Compile the C++ code using a C++ compiler (e.g., g++):
    ```bash
    g++ modular_exponentiation.cpp -o modular_exponentiation
    ```
3.  Run the executable:
    ```bash
    ./modular_exponentiation
    ```
    You will see the output of the predefined examples and then be prompted to enter your own values.

### Sample Input/Output

#### Predefined Examples Output:
--- Modular Exponentiation Examples ---
(2^10) % 1000 = 24 (Expected: 24)
(1000000000000000000^1000000000000000000) % 1000000007 = 
(987654321^123456789) % 1000000007 =
(5^0) % 100 = 1 (Expected: 1)
(0^5) % 100 = 0 (Expected: 0)