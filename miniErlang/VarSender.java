/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:42
 * @astdecl VarSender : SenderId ::= <Ident:String>;
 * @production VarSender : {@link SenderId} ::= <span class="component">&lt;Ident:{@link String}&gt;</span>;

 */
public class VarSender extends SenderId implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:268
   */
  public void print(){
       printer().append(getIdent());
    }
  /**
   * @declaredat ASTNode:1
   */
  public VarSender() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Ident"},
    type = {"String"},
    kind = {"Token"}
  )
  public VarSender(String p0) {
    setIdent(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public VarSender(beaver.Symbol p0) {
    setIdent(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public VarSender clone() throws CloneNotSupportedException {
    VarSender node = (VarSender) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public VarSender copy() {
    try {
      VarSender node = (VarSender) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:62
   */
  @Deprecated
  public VarSender fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public VarSender treeCopyNoTransform() {
    VarSender tree = (VarSender) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:92
   */
  public VarSender treeCopy() {
    VarSender tree = (VarSender) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Replaces the lexeme Ident.
   * @param value The new value for the lexeme Ident.
   * @apilevel high-level
   */
  public VarSender setIdent(String value) {
    tokenString_Ident = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_Ident;
  /**
   */
  public int Identstart;
  /**
   */
  public int Identend;
  /**
   * JastAdd-internal setter for lexeme Ident using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Ident
   * @apilevel internal
   */
  public VarSender setIdent(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setIdent is only valid for String lexemes");
    tokenString_Ident = (String)symbol.value;
    Identstart = symbol.getStart();
    Identend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme Ident.
   * @return The value for the lexeme Ident.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Ident")
  public String getIdent() {
    return tokenString_Ident != null ? tokenString_Ident : "";
  }

}
