
package check;

public class CheckUser {
    
    public static boolean IsRussian(String str) {
            char[] chr = str.toCharArray();
            for (int i = 0; i < chr.length; i++)
            {
                if (chr[i] >= 'А' && chr[i] <= 'я')
                    return true;
            }
            return false;
        }
    
    public static boolean haveNumber(String str) {
            char[] chr = str.toCharArray();
            for (int i = 0; i < chr.length; i++)
            {
                if (chr[i] >= '0' && chr[i] <= '9')
                    return true;
            }
            return false;
        }
    
    public static boolean haveUpperCase(String str) {
        String lowerStr = str.toLowerCase();
        if(str.equals(lowerStr)) {
            return false;
        }
        return true;
    }
    
    public static boolean haveLowerCase(String str) {
        String upperStr = str.toUpperCase();
        if(str.equals(upperStr)) {
            return false;
        }
        return true;
    }
    
}
