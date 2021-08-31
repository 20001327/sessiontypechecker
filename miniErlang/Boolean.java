/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:34
 * @astdecl Boolean : Literal ::= <BooleanValue:boolean>;
 * @production Boolean : {@link Literal} ::= <span class="component">&lt;BooleanValue:{@link boolean}&gt;</span>;

 */
public class Boolean extends Literal implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:410
   */
  public void print(){
       printer().append(getBooleanValue() ? "true" : "false");
    }
  /**
   * @declaredat ASTNode:1
   */
  public Boolean() {
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
    name = {"BooleanValue"},
    type = {"boolean"},
    kind = {"Token"}
  )
  public Boolean(boolean p0) {
    setBooleanValue(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public Boolean clone() throws CloneNotSupportedException {
    Boolean node = (Boolean) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public Boolean copy() {
    try {
      Boolean node = (Boolean) clone();
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
   * @declaredat ASTNode:59
   */
  @Deprecated
  public Boolean fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:69
   */
  public Boolean treeCopyNoTransform() {
    Boolean tree = (Boolean) copy();
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
   * @declaredat ASTNode:89
   */
  public Boolean treeCopy() {
    Boolean tree = (Boolean) copy();
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
   * Replaces the lexeme BooleanValue.
   * @param value The new value for the lexeme BooleanValue.
   * @apilevel high-level
   */
  public Boolean setBooleanValue(boolean value) {
    tokenboolean_BooleanValue = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected boolean tokenboolean_BooleanValue;
  /**
   * Retrieves the value for the lexeme BooleanValue.
   * @return The value for the lexeme BooleanValue.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="BooleanValue")
  public boolean getBooleanValue() {
    return tokenboolean_BooleanValue;
  }

}
