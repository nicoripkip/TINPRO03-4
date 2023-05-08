package util;


import util.Reader;


enum Token
{
    TOKEN_SQUARE_BRACKET,       // [ ]
    TOKEN_CURLY_BRACKET,        // { }
    TOKEN_TEXT_QUOTATION,       // " "
    TOKEN_FIELD_DELIMITER,      // :
    TOKEN_BLOCK_DELIMITER,      // ,
}


/**
 * @author Nico van Ommen | 1030808
 * @since 05/08/2023
 */
public class Serializer 
{
    private String lastchar;
    private int position;


    /**
     * Methode to generate the next token
     * 
     * @param data
     * @return
     */
    public Token nextToken(String data) 
    {


        return Token.TOKEN_SQUARE_BRACKET;
    }
}
