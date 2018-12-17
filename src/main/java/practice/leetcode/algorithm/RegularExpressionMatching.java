package practice.leetcode.algorithm;

/**
 * 10. Regular Expression Matching
 */
public class RegularExpressionMatching {
    /**
     * Is match boolean.
     *
     * @param s the s
     * @param p the p
     * @return the boolean
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        if (p.charAt(1) == '*') {
            while (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                } else {
                    s = s.substring(1);
                }
            }

            return isMatch(s, p.substring(2));
        } else {
            return !s.isEmpty() &&
                    (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') &&
                    isMatch(s.substring(1), p.substring(1));
        }
    }
}
