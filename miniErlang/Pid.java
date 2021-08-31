/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:31
 * @astdecl Pid : Literal ::= <Pid:String>;
 * @production Pid : {@link Literal} ::= <span class="component">&lt;Pid:{@link String}&gt;</span>;

 */
public class Pid extends Literal implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Pid() {
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
    name = {"Pid"},
    type = {"String"},
    kind = {"Token"}
  )
  public Pid(String p0) {
    setPid(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public Pid(beaver.Symbol p0) {
    setPid(p0);
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
  public Pid clone() throws CloneNotSupportedException {
    Pid node = (Pid) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Pid copy() {
    try {
      Pid node = (Pid) clone();
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
  public Pid fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Pid treeCopyNoTransform() {
    Pid tree = (Pid) copy();
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
  public Pid treeCopy() {
    Pid tree = (Pid) copy();
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
   * Replaces the lexeme Pid.
   * @param value The new value for the lexeme Pid.
   * @apilevel high-level
   */
  public Pid setPid(String value) {
    tokenString_Pid = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_Pid;
  /**
   */
  public int Pidstart;
  /**
   */
  public int Pidend;
  /**
   * JastAdd-internal setter for lexeme Pid using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Pid
   * @apilevel internal
   */
  public Pid setPid(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setPid is only valid for String lexemes");
    tokenString_Pid = (String)symbol.value;
    Pidstart = symbol.getStart();
    Pidend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme Pid.
   * @return The value for the lexeme Pid.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Pid")
  public String getPid() {
    return tokenString_Pid != null ? tokenString_Pid : "";
  }

}
