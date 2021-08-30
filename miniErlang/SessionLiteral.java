/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:45
 * @astdecl SessionLiteral : Session ::= Literal:Literal;
 * @production SessionLiteral : {@link Session} ::= <span class="component">Literal:{@link Literal}</span>;

 */
public class SessionLiteral extends Session implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public SessionLiteral() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Literal"},
    type = {"Literal"},
    kind = {"Child"}
  )
  public SessionLiteral(Literal p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public SessionLiteral clone() throws CloneNotSupportedException {
    SessionLiteral node = (SessionLiteral) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public SessionLiteral copy() {
    try {
      SessionLiteral node = (SessionLiteral) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public SessionLiteral fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public SessionLiteral treeCopyNoTransform() {
    SessionLiteral tree = (SessionLiteral) copy();
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
   * @declaredat ASTNode:90
   */
  public SessionLiteral treeCopy() {
    SessionLiteral tree = (SessionLiteral) copy();
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
   * Replaces the Literal child.
   * @param node The new node to replace the Literal child.
   * @apilevel high-level
   */
  public SessionLiteral setLiteral(Literal node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Literal child.
   * @return The current node used as the Literal child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Literal")
  public Literal getLiteral() {
    return (Literal) getChild(0);
  }
  /**
   * Retrieves the Literal child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Literal child.
   * @apilevel low-level
   */
  public Literal getLiteralNoTransform() {
    return (Literal) getChildNoTransform(0);
  }

}
