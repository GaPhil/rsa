# RSA Encryption

This programme is a short demonstraiton of the rsa encryption algorithm. 


###Key generation
The keys for the RSA algorithm are generated the following way:

1. Choose two distinct prime numbers **_p_** and **_q_**.
  - For security purposes, the integers **_p_** and **_q_** should be chosen at random, and should be similar in magnitude but 'differ in length by a few digits to make factoring harder. 

2. Compute **_n = pq_**.
  - **_n_** is used as the modulus for both the public and private keys.

3. Compute **_φ(n) = φ(p)φ(q) = (p − 1)(q − 1) = n − (p + q − 1)_**, where **_φ_** is Euler's totient function. 

4. Choose an integer **_e_** such that **_1 < e < φ(n)_** and **_gcd(e, φ(n)) = 1_**; i.e., **_e_** and **_φ(n)_** are coprime.

5. Determine **_d_** as **_d ≡ e−1 (mod φ(n))_**; i.e., **_d_** is the modular multiplicative inverse of **_e (mod φ(n))_**
  - This is more clearly stated as: solve for **_d_** given **_d⋅e ≡ 1 (mod φ(n))_**
  - **_e_** is released as the public key exponent.
  - **_d_** is kept as the private key exponent.

The public key consists of the modulus **_n_** and the public (or encryption) exponent **_e_**. The private key consists of the modulus **_n_** and the private (or decryption) exponent **_d_**, which must be kept secret. **_p, q_**, and **_φ(n)_** must also be kept secret because they can be used to calculate **_d_**.


###Encryption

**_c ≡ m<sup>e</sup> (mod n)_**

###Decryption

**_c<sup>d</sup> ≡ (m<sup>e</sup>)<sup>d</sup> ≡ m (mod n)_**

###Sources 

[Wikipedia: RSA (cryptosystem)](https://en.wikipedia.org/wiki/RSA_(cryptosystem))
