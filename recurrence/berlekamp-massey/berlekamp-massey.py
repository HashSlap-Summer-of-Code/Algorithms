# Run with: python berlekamp-massey.py
# Berlekamp-Massey Algorithm
# Finds the shortest linear recurrence (LFSR) that generates a given sequence over a finite field

def berlekamp_massey(sequence, mod=2):
    """
    Find the shortest linear feedback shift register (LFSR) that produces the given sequence
    over a finite field defined by the modulus (mod).
    
    Args:
        sequence (list): The input integer sequence.
        mod (int): The field modulus (default is 2).
    
    Returns:
        list: Coefficients of the minimal polynomial (LFSR).
    """
    n = len(sequence)
    C = [1] + [0] * n  # Current polynomial
    B = [1] + [0] * n  # Last successful polynomial
    L, m, b = 0, -1, 1

    for i in range(n):
        # Compute discrepancy
        d = sequence[i]
        for j in range(1, L + 1):
            d = (d + C[j] * sequence[i - j]) % mod

        if d == 0:
            continue  # No change needed
        T = C[:]
        coef = (d * pow(b, -1, mod)) % mod
        for j in range(n - i + m):
            if i - m + j < len(C):
                C[i - m + j] = (C[i - m + j] - coef * B[j]) % mod

        if 2 * L <= i:
            L = i + 1 - L
            B = T
            b = d
            m = i

    return C[:L + 1]


# ✅ Test Cases
def test_berlekamp_massey():
    print("Test Case 1 (mod 2):")
    seq1 = [1, 0, 0, 1, 1]
    print("Input:", seq1)
    print("Output:", berlekamp_massey(seq1, mod=2))  # Expected: [1, 0, 1, 1]

    print("\nTest Case 2 (mod 7):")
    seq2 = [0, 1, 1, 3, 2, 1, 6]
    print("Input:", seq2)
    print("Output:", berlekamp_massey(seq2, mod=7))  # Output will vary

    print("\nTest Case 3 (mod 5):")
    seq3 = [1, 2, 3, 0, 4]
    print("Input:", seq3)
    print("Output:", berlekamp_massey(seq3, mod=5))  # Output will vary


if __name__ == "__main__":
    test_berlekamp_massey()
