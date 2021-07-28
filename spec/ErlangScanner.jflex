package miniErlang; // The generated parser will belong to this package

import miniErlang.erlangParser.Terminals;
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
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
Integer        = [1-9][0-9]* | 0
Identifier     = [a-zA-Z][a-zA-Z0-9_]*
%%

// discard whitespace information and comments
{WhiteSpace}          { }
{LineComment}         { }
{MultiComment}        { }

"function"           { return sym(Terminals.FUNCTION); }
"receive"            { return sym(Terminals.RECEIVE); }
"clause"             { return sym(Terminals.CLAUSE); }
"call"               { return sym(Terminals.CALL); }
"match"              { return sym(Terminals.MATCH); }
"var"                { return sym(Terminals.VAR); }
"op"                 { return sym(Terminals.OPERATOR); }
"cons"               { return sym(Terminals.CONS); }
"remote"             { return sym(Terminals.REMOTE); }

"record_field        { return sym(Terminals.RECORDFIELD); }
"string"             { return sym(Terminals.STRING); }
"record"             { return sym(Terminals.RECORD); }
"atom"               { return sym(Terminals.ATOM); }
"tuple"              { return sym(Terminals.TUPLE); }

"int"                 { return sym(Terminals.INTTYPE); }

"("                   { return sym(Terminals.LBRACE); }
")"                   { return sym(Terminals.RBRACE); }
"{"                   { return sym(Terminals.LCURLYBRACE); }
"}"                   { return sym(Terminals.RCURLYBRACE); }
"["                   { return sym(Terminals.LBRACKET); }
"]"                   { return sym(Terminals.RBRACKET); }

","                   { return sym(Terminals.COMMA); }
"'"                   { return sym(Terminals.SINGLEMARKS); }
"\""                   { return sym(Terminals.DOUBLEMARKS); }
"<"                   { return sym(Terminals.LESSTHAN); }
"<"                   { return sym(Terminals.MORETHAN); }
"!"                   { return sym(Terminals.SEND); }
"="                   { return sym(Terminals.EQUALS); }

"if"                  { return sym(Terminals.IF); }
"else"                { return sym(Terminals.ELSE); }
"case"               { return sym(Terminals.CASE); }

{Integer}             { return sym(Terminals.INTEGER); }
{Identifier}          { return sym(Terminals.IDENTIFIER); }

// fall through errors
.                     { throw new beaver.Scanner.Exception("illegal character \"" + yytext() + "\" at line " + yyline + "," + yycolumn); }
