package JUnit;

import Enums.OperatorEnum;
import LexicalAnalyzer.LexicalAnalyzer;
import LexicalAnalyzer.LineReader;
import LexicalAnalyzer.Token;
import LexicalUnit.IdentificatorUnit;
import LexicalUnit.OperatorUnit;
import SyntaxicAnalyzer.TokenReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenReaderTest {

    private static List<Token> tokens;
    private static TokenReader tokenReader;
    private static int cursor;
    private static Token token;

    @BeforeAll
    public static void init(){
        tokens = new ArrayList<>();
        token = new Token(2, new OperatorUnit('+'));
        tokens.add(new Token(1, new IdentificatorUnit("Procedure")));
        tokens.add(token);
        cursor = 0;
        tokenReader = new TokenReader(tokens);
    }

    @Test
    void getCurrentToken() {
        tokenReader.setCursor(0);
        String token = tokenReader.getCurrentToken().getStrToken();
        assertEquals("Procedure", token);
    }

    @Test
    void moveCursorForward() {
        tokenReader.setCursor(0);
        tokenReader.nextToken();
        assertEquals(1, tokenReader.getCursor());
    }

    @Test
    void moveCursorBack() {
        tokenReader.setCursor(0);
        tokenReader.moveCursorForward();
        assertEquals(token, tokenReader.getCurrentToken());
    }

    @Test
    void previousTokens() {
        tokenReader.moveCursorForward();
        tokenReader.moveCursorForward();
        tokenReader.previousToken();
        assertEquals(token, tokenReader.getCurrentToken());
    }

    @Test
    void nextToken() {
        tokenReader.setCursor(0);
        assertEquals(token.getStrToken(), tokenReader.nextToken().getStrToken());
    }


}