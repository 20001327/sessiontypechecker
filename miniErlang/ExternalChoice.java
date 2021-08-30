/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:48
 * @astdecl ExternalChoice : Session ::= Receives:SessionReceive*;
 * @production ExternalChoice : {@link Session} ::= <span class="component">Receives:{@link SessionReceive}*</span>;

 */
public class ExternalChoice extends Session implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public ExternalChoice() {
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
    name = {"Receives"},
    type = {"List<SessionReceive>"},
    kind = {"List"}
  )
  public ExternalChoice(List<SessionReceive> p0) {
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
  public ExternalChoice clone() throws CloneNotSupportedException {
    ExternalChoice node = (ExternalChoice) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public ExternalChoice copy() {
    try {
      ExternalChoice node = (ExternalChoice) clone();
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
  public ExternalChoice fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public ExternalChoice treeCopyNoTransform() {
    ExternalChoice tree = (ExternalChoice) copy();
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
  public ExternalChoice treeCopy() {
    ExternalChoice tree = (ExternalChoice) copy();
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
   * Replaces the Receives list.
   * @param list The new list node to be used as the Receives list.
   * @apilevel high-level
   */
  public ExternalChoice setReceivesList(List<SessionReceive> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Receives list.
   * @return Number of children in the Receives list.
   * @apilevel high-level
   */
  public int getNumReceives() {
    return getReceivesList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Receives list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Receives list.
   * @apilevel low-level
   */
  public int getNumReceivesNoTransform() {
    return getReceivesListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Receives list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Receives list.
   * @apilevel high-level
   */
  public SessionReceive getReceives(int i) {
    return (SessionReceive) getReceivesList().getChild(i);
  }
  /**
   * Check whether the Receives list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasReceives() {
    return getReceivesList().getNumChild() != 0;
  }
  /**
   * Append an element to the Receives list.
   * @param node The element to append to the Receives list.
   * @apilevel high-level
   */
  public ExternalChoice addReceives(SessionReceive node) {
    List<SessionReceive> list = (parent == null) ? getReceivesListNoTransform() : getReceivesList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public ExternalChoice addReceivesNoTransform(SessionReceive node) {
    List<SessionReceive> list = getReceivesListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Receives list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public ExternalChoice setReceives(SessionReceive node, int i) {
    List<SessionReceive> list = getReceivesList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Receives list.
   * @return The node representing the Receives list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Receives")
  public List<SessionReceive> getReceivesList() {
    List<SessionReceive> list = (List<SessionReceive>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Receives list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Receives list.
   * @apilevel low-level
   */
  public List<SessionReceive> getReceivesListNoTransform() {
    return (List<SessionReceive>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Receives list without
   * triggering rewrites.
   */
  public SessionReceive getReceivesNoTransform(int i) {
    return (SessionReceive) getReceivesListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Receives list.
   * @return The node representing the Receives list.
   * @apilevel high-level
   */
  public List<SessionReceive> getReceivess() {
    return getReceivesList();
  }
  /**
   * Retrieves the Receives list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Receives list.
   * @apilevel low-level
   */
  public List<SessionReceive> getReceivessNoTransform() {
    return getReceivesListNoTransform();
  }

}
