package miniErlang; // The generated parser will belong to this package

import miniErlang.ErlangParser.Terminals;
// The terminals are implicitly defined in the parser
%%

// define the signature for the generated scanner
%public
%final
%class ErlangScanner
%extends beaver.Scanner


// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol
%function nextToken
%yylexthrow beaver.Scanner.Exception
%eofval{
    return new beaver.Symbol(Terminals.EOF, "end-of-file");
%eofval}

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
  private beaver.Symbol sym(short id, Object value) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), value);
  }
%}


LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
Symbol         = '\='|'\-'|'\*'|'\+'|'\\'|'=='|'=<'
StringValue    = \"(.[^\"]*)\"
Integer        = [1-9][0-9]* | 0
Identifier     = [a-zA-Z][a-zA-Z0-9_]*
IdInSingle     = '{Identifier}'

%%

// discard whitespace information and comments
{WhiteSpace}          { }

"function"           { return sym(Terminals.FUNCTION); }
"'receive'"          { return sym(Terminals.RECEIVE); }
"'case'"             { return sym(Terminals.CASE); }
"clause"             { return sym(Terminals.CLAUSE); }
"call"               { return sym(Terminals.CALL); }
"match"              { return sym(Terminals.MATCH); }
"var"                { return sym(Terminals.VAR); }
"op"                 { return sym(Terminals.OPERATOR); }
"string"             { return sym(Terminals.STRING); }
"attribute"          { return sym(Terminals.ATTRIBUTE); }
"module"             { return sym(Terminals.MODULE); }
"type"               { return sym(Terminals.TYPE); }
"start"              { return sym(Terminals.START); }
"true"               { return sym(Terminals.TRUE); }
"false"              { return sym(Terminals.FALSE); }
"register"           { return sym(Terminals.REGISTER); }
"unregister"         { return sym(Terminals.UNREGISTER); }
"spawn"              { return sym(Terminals.SPAWN); }
"End"                { return sym(Terminals.END); }

"string"             { return sym(Terminals.STRING); }
"atom"               { return sym(Terminals.ATOM); }
"integer"            { return sym(Terminals.INT); }
"tuple"              { return sym(Terminals.TUPLE); }
"nil"                { return sym(Terminals.NULL); }

"{"                   { return sym(Terminals.LCURLYBRACE); }
"}"                   { return sym(Terminals.RCURLYBRACE); }
"["                   { return sym(Terminals.LBRACKET); }
"("                   { return sym(Terminals.LQUAD); }
"]"                   { return sym(Terminals.RBRACKET); }
")"                   { return sym(Terminals.RQUAD); }

"."                   { return sym(Terminals.DOT); }
"-"                   { return sym(Terminals.MINUS); }
"+"                   { return sym(Terminals.PLUS); }
":"                   { return sym(Terminals.COLONS); }
","                   { return sym(Terminals.COMMA); }
"!"                   { return sym(Terminals.SESSIONSEND); }
"?"                   { return sym(Terminals.SESSIONRECEIVE); }
"@"                   { return sym(Terminals.INTERNALCHOICE); }
"&"                   { return sym(Terminals.EXTERNALCHOICE); }
"'!'"                 { return sym(Terminals.SEND); }
"'/'"                 { return sym(Terminals.DIVISION); }
"'<'"                 { return sym(Terminals.LESS); }

"rec"                 { return sym(Terminals.REC); }
"$"                   { return sym(Terminals.RECSYM); }
"'"                   { return sym(Terminals.SINGLEMARKS); }
"<"                   { return sym(Terminals.OPENANGULAR); }
">"                   { return sym(Terminals.CLOSEANGULAR); }
"String"              { return sym(Terminals.STRINGTYPE); }
"Int"                 { return sym(Terminals.INTTYPE); }
"Atom"                { return sym(Terminals.ATOMTYPE); }
"Boolean"             { return sym(Terminals.BOOLEANTYPE); }


{Symbol}              { return sym(Terminals.SYMBOL); }
{Integer}             { return sym(Terminals.INTEGER); }
{Identifier}          { return sym(Terminals.IDENTIFIER); }
{IdInSingle}          { return sym(Terminals.ATOMID); }
{StringValue}         { return sym(Terminals.STRINGVALUE); }

// fall through errors
.                     { throw new beaver.Scanner.Exception("illegal character \"" + yytext() + "\" at line " + yyline + "," + yycolumn); }
