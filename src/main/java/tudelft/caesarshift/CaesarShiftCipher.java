package tudelft.caesarshift;

public class CaesarShiftCipher {

    public String CaesarShiftCipher(String message, int shift){
        StringBuilder sb = new StringBuilder();
        char currentChar;

        shift = shift % 26;

        for(int i = 0; i < message.length(); i++){
            currentChar = message.charAt(i);

            // Validación
            if (currentChar < 'a' || currentChar > 'z') {
                return "invalid";
            }

            // Aplicar shift
            char shifted = (char)(currentChar + shift);

            if (shifted > 'z') {
                shifted -= 26;
            } else if (shifted < 'a') {
                shifted += 26;
            }

            sb.append(shifted);
        }

        return sb.toString();
    }
}
