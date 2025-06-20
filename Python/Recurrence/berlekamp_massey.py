# Run with: python berlekamp_massey.py
# Berlekamp-Massey Algorithm
# Finds the shortest linear recurrence relation for a sequence over a finite field

def berlekamp_massey(sequence, mod=2):
    n = len(sequence)
    C = [1] + [0] * n  # Connection polynomial
    B = [1] + [0] * n  # Backup copy of last C
    L = 0  # Current length of the minimal recurrence
    m = -1
    b = 1  # Last non-zero discrepancy

    for i in range(n):
        # Compute discrepancy
        d = sequence[i]
        for j in range(1, L + 1):
            d = (d + C[j] * sequence[i - j]) % mod

        if d == 0:
            continue

        T = C[:]
        coef = (d * pow(b, -1, mod)) % mod
        for j in range(n - i + m):
            C[i - m + j] = (C[i - m + j] - coef * B[j]) % mod

        if 2 * L <= i:
            L = i + 1 - L
            B = T
            b = d
            m = i

    return C[:L + 1]

# 📘 Example Explanation:
# For input sequence: [1, 0, 0, 1, 1], the minimal LFSR (mod 2) is x^3 + x + 1

# 🧪 Test Cases
if __name__ == "__main__":
    # Binary sequence test (mod 2)
    seq1 = [1, 0, 0, 1, 1]
    print("Input Sequence:", seq1)
    result1 = berlekamp_massey(seq1, mod=2)
    print("Minimal Recurrence Coefficients (mod 2):", result1)
    
    # Mod 7 test
    seq2 = [0, 1, 1, 3, 2, 1, 6]
    print("\nInput Sequence:", seq2)
    result2 = berlekamp_massey(seq2, mod=7)
    print("Minimal Recurrence Coefficients (mod 7):", result2)
