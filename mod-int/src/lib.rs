pub struct ModInt;

/// Note:
/// The following functions expect certain guarantees (specifically, overflows, works for ~ mod_value <= 1e9, prime).
/// Use with caution
/// TODO: Switch to Generics
impl ModInt {
    pub fn multiply_i32(multiplicand: i32, multiplier: i32, mod_value: i32) -> i32 {
        let multiplicand = multiplicand.rem_euclid(mod_value);
        let multiplier = multiplier.rem_euclid(mod_value);
        ((multiplicand as i64 * multiplier as i64) % mod_value as i64) as i32
    }

    pub fn multiply_i64(multiplicand: i64, multiplier: i64, mod_value: i64) -> i64 {
        let multiplicand = multiplicand.rem_euclid(mod_value);
        let multiplier = multiplier.rem_euclid(mod_value);
        (multiplicand * multiplier) % mod_value
    }

    pub fn add_i32(augend: i32, addend: i32, mod_value: i32) -> i32 {
        (augend.rem_euclid(mod_value) + addend.rem_euclid(mod_value)) % mod_value
    }

    pub fn add_i64(augend: i64, addend: i64, mod_value: i64) -> i64 {
        (augend.rem_euclid(mod_value) + addend.rem_euclid(mod_value)) % mod_value
    }

    pub fn subtract_i32(minuend: i32, subtrahend: i32, mod_value: i32) -> i32 {
        let result = (minuend.rem_euclid(mod_value) - subtrahend.rem_euclid(mod_value)) % mod_value;
        if result < 0 { result + mod_value } else { result }
    }

    pub fn subtract_i64(minuend: i64, subtrahend: i64, mod_value: i64) -> i64 {
        let result = (minuend.rem_euclid(mod_value) - subtrahend.rem_euclid(mod_value)) % mod_value;
        if result < 0 { result + mod_value } else { result }
    }

    pub fn bin_exp_i32(base: i32, exp: i32, mod_value: i32) -> i32 {
        let mut base = base.rem_euclid(mod_value) as i64;
        let mut exp = exp as i64;
        let mut result = 1_i64;
        while exp > 0 {
            if exp & 1 > 0 {
                result = (result * base) % mod_value as i64;
            }
            base = (base * base) % mod_value as i64;
            exp >>= 1;
        }
        result as i32
    }

    pub fn bin_exp_i64(base: i64, exp: i64, mod_value: i64) -> i64 {
        let mut base = base.rem_euclid(mod_value);
        let mut exp = exp;
        let mut result = 1_i64;
        while exp > 0 {
            if exp & 1 > 0 {
                result = (result * base) % mod_value;
            }
            base = (base * base) % mod_value;
            exp >>= 1;
        }
        result
    }

    pub fn inverse_i32(num: i32, mod_value: i32) -> i32 {
        Self::bin_exp_i32(num, mod_value - 2, mod_value)
    }

    pub fn inverse_i64(num: i64, mod_value: i64) -> i64 {
        Self::bin_exp_i64(num, mod_value - 2, mod_value)
    }

    pub fn get_factorial_inverse(fac: &[i32], mod_value: i32) -> Vec<i32> {
        let mut fac_inv = vec![1; fac.len()];
        fac_inv[fac.len() - 1] = Self::inverse_i32(fac[fac.len() - 1], mod_value);
        for i in (1..fac.len() - 1).rev() {
            fac_inv[i] = Self::multiply_i32(fac_inv[i + 1], (i + 1) as i32, mod_value);
        }
        fac_inv
    }
}
