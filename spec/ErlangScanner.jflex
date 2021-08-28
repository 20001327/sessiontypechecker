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
StringValue    = \"[a-zA-Z0-9_ ]*\"
Integer        = [1-9][0-9]* | 0
Atom           = '[a-z][a-zA-Z0-9_ ]*'
Identifier     = [a-zA-Z][a-zA-Z0-9_]*
Variable       = '[A-Z][a-zA-Z0-9_]*'
Symbol         = \=|\-|\*|\+|\/|\\

%%

// discard whitespace information and comments
{WhiteSpace}          { }

"function"           { return sym(Terminals.FUNCTION); }
"'receive'"          { return sym(Terminals.RECEIVE); }
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
"spawn"              { return sym(Terminals.SPAWN); }

"string"             { return sym(Terminals.STRING); }
"atom"               { return sym(Terminals.ATOM); }
"tuple"              { return sym(Terminals.TUPLE); }
"integer"            { return sym(Terminals.INTTYPE); }
"nil"                { return sym(Terminals.NULL); }


"{"                   { return sym(Terminals.LCURLYBRACE); }
"}"                   { return sym(Terminals.RCURLYBRACE); }
"["                   { return sym(Terminals.LBRACKET); }
"]"                   { return sym(Terminals.RBRACKET); }

","                   { return sym(Terminals.COMMA); }
"'"                   { return sym(Terminals.SINGLEMARKS); }
"!"                   { return sym(Terminals.SEND); }

"case"                { return sym(Terminals.CASE); }

{Integer}             { return sym(Terminals.INTEGER); }
{Identifier}          { return sym(Terminals.IDENTIFIER); }
{Atom}                { return sym(Terminals.ATOMID); }
{Variable}            { return sym(Terminals.VARIABLEID); }
{StringValue}         { return sym(Terminals.STRINGVALUE); }
{Symbol}              { return sym(Terminals.SYMBOL); }

// fall through errors
.                     { throw new beaver.Scanner.Exception("illegal character \"" + yytext() + "\" at line " + yyline + "," + yycolumn); }
