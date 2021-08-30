/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:47
 * @astdecl InternalChoice : Session ::= Sends:SessionSend*;
 * @production InternalChoice : {@link Session} ::= <span class="component">Sends:{@link SessionSend}*</span>;

 */
public class InternalChoice extends Session implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public InternalChoice() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Sends"},
    type = {"List<SessionSend>"},
    kind = {"List"}
  )
  public InternalChoice(List<SessionSend> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
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
  public InternalChoice clone() throws CloneNotSupportedException {
    InternalChoice node = (InternalChoice) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public InternalChoice copy() {
    try {
      InternalChoice node = (InternalChoice) clone();
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
  public InternalChoice fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public InternalChoice treeCopyNoTransform() {
    InternalChoice tree = (InternalChoice) copy();
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
  public InternalChoice treeCopy() {
    InternalChoice tree = (InternalChoice) copy();
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
   * Replaces the Sends list.
   * @param list The new list node to be used as the Sends list.
   * @apilevel high-level
   */
  public InternalChoice setSendsList(List<SessionSend> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Sends list.
   * @return Number of children in the Sends list.
   * @apilevel high-level
   */
  public int getNumSends() {
    return getSendsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Sends list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Sends list.
   * @apilevel low-level
   */
  public int getNumSendsNoTransform() {
    return getSendsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Sends list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Sends list.
   * @apilevel high-level
   */
  public SessionSend getSends(int i) {
    return (SessionSend) getSendsList().getChild(i);
  }
  /**
   * Check whether the Sends list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasSends() {
    return getSendsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Sends list.
   * @param node The element to append to the Sends list.
   * @apilevel high-level
   */
  public InternalChoice addSends(SessionSend node) {
    List<SessionSend> list = (parent == null) ? getSendsListNoTransform() : getSendsList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public InternalChoice addSendsNoTransform(SessionSend node) {
    List<SessionSend> list = getSendsListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Sends list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public InternalChoice setSends(SessionSend node, int i) {
    List<SessionSend> list = getSendsList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Sends list.
   * @return The node representing the Sends list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Sends")
  public List<SessionSend> getSendsList() {
    List<SessionSend> list = (List<SessionSend>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Sends list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Sends list.
   * @apilevel low-level
   */
  public List<SessionSend> getSendsListNoTransform() {
    return (List<SessionSend>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Sends list without
   * triggering rewrites.
   */
  public SessionSend getSendsNoTransform(int i) {
    return (SessionSend) getSendsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Sends list.
   * @return The node representing the Sends list.
   * @apilevel high-level
   */
  public List<SessionSend> getSendss() {
    return getSendsList();
  }
  /**
   * Retrieves the Sends list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Sends list.
   * @apilevel low-level
   */
  public List<SessionSend> getSendssNoTransform() {
    return getSendsListNoTransform();
  }

}
