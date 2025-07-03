package lib;

public class PasswordValidator {
    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     * @param password ที่ต้องการตรวจสอบ
     * @return ระดับตวามปลอดภัยของรหัส
     */
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 

      boolean UpperCase = false ;
      boolean LowerCase = false ;
      boolean Special = false ;
      boolean Digit = false ;

      //วนลูปเช็ครหัสผ่านมี ตัวพิมพ์เล็ก,ตัวเลข,ตัวพิมพ์ใหญ่,ตัวพิเศษ ไหม
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                UpperCase = true; 
            }
            else if (Character.isLowerCase(c)) {
                LowerCase = true; 
            }
            else if (Character.isDigit(c)) {
                Digit = true; 
            }else Special = true;
        }

        //ตรวจว่าเกิน 8 ตัวอักษรหรือเป็นช่องว่างไหม
         int minLength = 8; // TODO: มีอะไรขาดหายไปที่บรรทัดนี้?
        if (password.length() < minLength || password == null) {
            return PasswordStrength.INVALID;
            }
        
        //ดูว่าผ่านไปแล้วกี่อย่าง
        int passed = 0;
        if (password.length() >= minLength || password == null) {passed++; }
        if (UpperCase) {passed++; }
        if (LowerCase) {passed++; }
        if (Digit) {passed++; }
        if (Special) {passed++; }

        //กำหนดว่าต้องผ่านกี่อย่างถึงได้ความปลอดภัยเท่าไหร่
        if (passed >= 4) {
            return PasswordStrength.STRONG;
        }else if (passed >= 3) {
            return PasswordStrength.MEDIUM;
        }else if (passed >= 2) {
            return PasswordStrength.WEAK;
        }
        
        return PasswordStrength.INVALID  ; 
    }
}