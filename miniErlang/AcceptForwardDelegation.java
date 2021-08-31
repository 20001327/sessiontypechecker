/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:50
 * @astdecl AcceptForwardDelegation : Session ::= Delegate:Atom Next:Session;
 * @production AcceptForwardDelegation : {@link Session} ::= <span class="component">Delegate:{@link Atom}</span> <span class="component">Next:{@link Session}</span>;

 */
public class AcceptForwardDelegation extends Session implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:227
   */
  public void print(){
        getDelegate().print();
        printer().append("<<");
        printer().append(".");
        getNext().print();
    }
  /**
   * @declaredat ASTNode:1
   */
  public AcceptForwardDelegation() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Delegate", "Next"},
    type = {"Atom", "Session"},
    kind = {"Child", "Child"}
  )
  public AcceptForwardDelegation(Atom p0, Session p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public AcceptForwardDelegation clone() throws CloneNotSupportedException {
    AcceptForwardDelegation node = (AcceptForwardDelegation) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public AcceptForwardDelegation copy() {
    try {
      AcceptForwardDelegation node = (AcceptForwardDelegation) clone();
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
   * @declaredat ASTNode:61
   */
  @Deprecated
  public AcceptForwardDelegation fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public AcceptForwardDelegation treeCopyNoTransform() {
    AcceptForwardDelegation tree = (AcceptForwardDelegation) copy();
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
   * @declaredat ASTNode:91
   */
  public AcceptForwardDelegation treeCopy() {
    AcceptForwardDelegation tree = (AcceptForwardDelegation) copy();
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
   * Replaces the Delegate child.
   * @param node The new node to replace the Delegate child.
   * @apilevel high-level
   */
  public AcceptForwardDelegation setDelegate(Atom node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Delegate child.
   * @return The current node used as the Delegate child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Delegate")
  public Atom getDelegate() {
    return (Atom) getChild(0);
  }
  /**
   * Retrieves the Delegate child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Delegate child.
   * @apilevel low-level
   */
  public Atom getDelegateNoTransform() {
    return (Atom) getChildNoTransform(0);
  }
  /**
   * Replaces the Next child.
   * @param node The new node to replace the Next child.
   * @apilevel high-level
   */
  public AcceptForwardDelegation setNext(Session node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Next child.
   * @return The current node used as the Next child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Next")
  public Session getNext() {
    return (Session) getChild(1);
  }
  /**
   * Retrieves the Next child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Next child.
   * @apilevel low-level
   */
  public Session getNextNoTransform() {
    return (Session) getChildNoTransform(1);
  }

}
