package utils;

public class StringUtils {

    public static boolean isBlank( String s ) {
        if( s == null || s.length() == 0 ) {
            return true;
        }
        for( int i = 0; i < s.length(); i++ ) {
            if( s.charAt( i ) != ' ' ) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNotBlank( String s ) {
        return !isBlank(s);
    }
    
    public static boolean isAsciiPrintable( String s ) {
        if( s == null ) {
            return false;
        }
        for( int i = 0; i < s.length(); i++ ) {
            if( (int)s.charAt( i ) < 32 || (int)s.charAt( i ) > 126 ) {
                return false;
            }
        }
        return true;
    }
}
