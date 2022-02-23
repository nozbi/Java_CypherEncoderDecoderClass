public class CypherEncoderDecoder
{
    private char alphabet[];
    private int indexDelta;

    public CypherEncoderDecoder()
    {
        char defaultAlphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        this.alphabet = defaultAlphabet;
        this.indexDelta = 1;
    }

    public CypherEncoderDecoder(char alphabetParameter[], int indexDeltaParameter)
    {
        this.alphabet = alphabetParameter;
        this.indexDelta = indexDeltaParameter;
    }

    public String encrypt(String textParameter)
    {
        return this.changeLetters(textParameter, this.indexDelta);
    }

    public String decrypt(String textParameter)
    {
        return this.changeLetters(textParameter, -this.indexDelta);
    }

    private String changeLetters(String textParameter, int indexDeltaParameter)
    {
        textParameter.toUpperCase();
        char chars[] = textParameter.toCharArray();
        char newChars[] = new char[chars.length];
        for(int i = 0; i < chars.length; i++)
        {
            int index = 0;
            for(int j = 0; j < this.alphabet.length; j++)
            {
                if(chars[i] == this.alphabet[j])
                {
                    index = j;
                    break;
                }
                else
                {
                    index = -1;
                }
            }
            if(index == -1)
            {
                newChars[i] = ' ';
            }
            else
            {
                int newIndex;
                if(indexDeltaParameter < 0)
                {
                    newIndex = index + indexDeltaParameter;
                    if(newIndex < 0)
                    {
                        newIndex = this.alphabet.length + newIndex;
                    }  
                }
                else
                {
                    newIndex = (index + indexDeltaParameter) %this.alphabet.length;
                }
                newChars[i] = this.alphabet[newIndex];
            }
        }
        String string = new String(newChars);
        return string;
    }
}