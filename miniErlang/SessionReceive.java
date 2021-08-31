/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:45
 * @astdecl SessionReceive : Session ::= Recipient:Atom Label:Atom Type:LiteralType* Next:Session;
 * @production SessionReceive : {@link Session} ::= <span class="component">Recipient:{@link Atom}</span> <span class="component">Label:{@link Atom}</span> <span class="component">Type:{@link LiteralType}*</span> <span class="component">Next:{@link Session}</span>;

 */
public class SessionReceive extends Session implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:169
   */
  public void print(){
        getRecipient().print();
        printer().append("?");
        getLabel().print();
        if(getNumType()>0){
        printer().append("<");
            for (int i=0; i<getNumType(); i++) {
                getType(i).print();
                if(i<getNumType()-1){
                    printer().append(",");
                }
            }
        printer().append(">");
        }
        printer().append(".");
        getNext().print();
    }
  /**
   * @declaredat ASTNode:1
   */
  public SessionReceive() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Recipient", "Label", "Type", "Next"},
    type = {"Atom", "Atom", "List<LiteralType>", "Session"},
    kind = {"Child", "Child", "List", "Child"}
  )
  public SessionReceive(Atom p0, Atom p1, List<LiteralType> p2, Session p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public SessionReceive clone() throws CloneNotSupportedException {
    SessionReceive node = (SessionReceive) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
   */
  public SessionReceive copy() {
    try {
      SessionReceive node = (SessionReceive) clone();
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
   * @declaredat ASTNode:64
   */
  @Deprecated
  public SessionReceive fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:74
   */
  public SessionReceive treeCopyNoTransform() {
    SessionReceive tree = (SessionReceive) copy();
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
   * @declaredat ASTNode:94
   */
  public SessionReceive treeCopy() {
    SessionReceive tree = (SessionReceive) copy();
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
   * Replaces the Recipient child.
   * @param node The new node to replace the Recipient child.
   * @apilevel high-level
   */
  public SessionReceive setRecipient(Atom node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Recipient child.
   * @return The current node used as the Recipient child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Recipient")
  public Atom getRecipient() {
    return (Atom) getChild(0);
  }
  /**
   * Retrieves the Recipient child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Recipient child.
   * @apilevel low-level
   */
  public Atom getRecipientNoTransform() {
    return (Atom) getChildNoTransform(0);
  }
  /**
   * Replaces the Label child.
   * @param node The new node to replace the Label child.
   * @apilevel high-level
   */
  public SessionReceive setLabel(Atom node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Label child.
   * @return The current node used as the Label child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Label")
  public Atom getLabel() {
    return (Atom) getChild(1);
  }
  /**
   * Retrieves the Label child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Label child.
   * @apilevel low-level
   */
  public Atom getLabelNoTransform() {
    return (Atom) getChildNoTransform(1);
  }
  /**
   * Replaces the Type list.
   * @param list The new list node to be used as the Type list.
   * @apilevel high-level
   */
  public SessionReceive setTypeList(List<LiteralType> list) {
    setChild(list, 2);
    return this;
  }
  /**
   * Retrieves the number of children in the Type list.
   * @return Number of children in the Type list.
   * @apilevel high-level
   */
  public int getNumType() {
    return getTypeList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Type list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Type list.
   * @apilevel low-level
   */
  public int getNumTypeNoTransform() {
    return getTypeListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Type list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Type list.
   * @apilevel high-level
   */
  public LiteralType getType(int i) {
    return (LiteralType) getTypeList().getChild(i);
  }
  /**
   * Check whether the Type list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasType() {
    return getTypeList().getNumChild() != 0;
  }
  /**
   * Append an element to the Type list.
   * @param node The element to append to the Type list.
   * @apilevel high-level
   */
  public SessionReceive addType(LiteralType node) {
    List<LiteralType> list = (parent == null) ? getTypeListNoTransform() : getTypeList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public SessionReceive addTypeNoTransform(LiteralType node) {
    List<LiteralType> list = getTypeListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Type list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public SessionReceive setType(LiteralType node, int i) {
    List<LiteralType> list = getTypeList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Type list.
   * @return The node representing the Type list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Type")
  public List<LiteralType> getTypeList() {
    List<LiteralType> list = (List<LiteralType>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Type list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Type list.
   * @apilevel low-level
   */
  public List<LiteralType> getTypeListNoTransform() {
    return (List<LiteralType>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Type list without
   * triggering rewrites.
   */
  public LiteralType getTypeNoTransform(int i) {
    return (LiteralType) getTypeListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Type list.
   * @return The node representing the Type list.
   * @apilevel high-level
   */
  public List<LiteralType> getTypes() {
    return getTypeList();
  }
  /**
   * Retrieves the Type list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Type list.
   * @apilevel low-level
   */
  public List<LiteralType> getTypesNoTransform() {
    return getTypeListNoTransform();
  }
  /**
   * Replaces the Next child.
   * @param node The new node to replace the Next child.
   * @apilevel high-level
   */
  public SessionReceive setNext(Session node) {
    setChild(node, 3);
    return this;
  }
  /**
   * Retrieves the Next child.
   * @return The current node used as the Next child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Next")
  public Session getNext() {
    return (Session) getChild(3);
  }
  /**
   * Retrieves the Next child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Next child.
   * @apilevel low-level
   */
  public Session getNextNoTransform() {
    return (Session) getChildNoTransform(3);
  }

}
