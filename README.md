# rsa
RSA encryption

This programme is a short demonstraiton of the rsa encryption algorithm. 


Key generation
The keys for the RSA algorithm are generated the following way:
1. Choose two distinct prime numbers p and q.
  - For security purposes, the integers p and q should be chosen at random, and should be similar in magnitude but 'differ in length by a few digits to make factoring harder. 
2. Compute n = pq.
  - n is used as the modulus for both the public and private keys.
3. Compute φ(n) = φ(p)φ(q) = (p − 1)(q − 1) = n − (p + q − 1), where φ is Euler's totient function. 
4. Choose an integer e such that 1 < e < φ(n) and gcd(e, φ(n)) = 1; i.e., e and φ(n) are coprime.
5. Determine d as d ≡ e−1 (mod φ(n)); i.e., d is the modular multiplicative inverse of e (modulo φ(n))
  - This is more clearly stated as: solve for d given d⋅e ≡ 1 (mod φ(n))
  - e is released as the public key exponent.
  - d is kept as the private key exponent.

The public key consists of the modulus n and the public (or encryption) exponent e. The private key consists of the modulus n and the private (or decryption) exponent d, which must be kept secret. p, q, and φ(n) must also be kept secret because they can be used to calculate d.
