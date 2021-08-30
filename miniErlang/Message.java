/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:10
 * @astdecl Message : Term ::= Sender:SenderId Label:Atom Payload:Expression*;
 * @production Message : {@link Term} ::= <span class="component">Sender:{@link SenderId}</span> <span class="component">Label:{@link Atom}</span> <span class="component">Payload:{@link Expression}*</span>;

 */
public class Message extends Term implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:146
   */
  public void print() {
        printer().append("{");
        getSender().print();
        printer().append(",");
        getLabel().print();
        if(getNumPayload()>0){
            printer().append(",");
        }
        for(int i=0;i<getNumPayload();i++){
            getPayload(i).print();
            if(i<getNumPayload()-1){
                printer().append(",");
            }
        }
        printer().append("}");
    }
  /**
   * @declaredat ASTNode:1
   */
  public Message() {
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
    children = new ASTNode[3];
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Sender", "Label", "Payload"},
    type = {"SenderId", "Atom", "List<Expression>"},
    kind = {"Child", "Child", "List"}
  )
  public Message(SenderId p0, Atom p1, List<Expression> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:25
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    printer_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public Message clone() throws CloneNotSupportedException {
    Message node = (Message) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public Message copy() {
    try {
      Message node = (Message) clone();
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
   * @declaredat ASTNode:63
   */
  @Deprecated
  public Message fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public Message treeCopyNoTransform() {
    Message tree = (Message) copy();
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
   * @declaredat ASTNode:93
   */
  public Message treeCopy() {
    Message tree = (Message) copy();
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
   * Replaces the Sender child.
   * @param node The new node to replace the Sender child.
   * @apilevel high-level
   */
  public Message setSender(SenderId node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Sender child.
   * @return The current node used as the Sender child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Sender")
  public SenderId getSender() {
    return (SenderId) getChild(0);
  }
  /**
   * Retrieves the Sender child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Sender child.
   * @apilevel low-level
   */
  public SenderId getSenderNoTransform() {
    return (SenderId) getChildNoTransform(0);
  }
  /**
   * Replaces the Label child.
   * @param node The new node to replace the Label child.
   * @apilevel high-level
   */
  public Message setLabel(Atom node) {
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
   * Replaces the Payload list.
   * @param list The new list node to be used as the Payload list.
   * @apilevel high-level
   */
  public Message setPayloadList(List<Expression> list) {
    setChild(list, 2);
    return this;
  }
  /**
   * Retrieves the number of children in the Payload list.
   * @return Number of children in the Payload list.
   * @apilevel high-level
   */
  public int getNumPayload() {
    return getPayloadList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Payload list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Payload list.
   * @apilevel low-level
   */
  public int getNumPayloadNoTransform() {
    return getPayloadListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Payload list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Payload list.
   * @apilevel high-level
   */
  public Expression getPayload(int i) {
    return (Expression) getPayloadList().getChild(i);
  }
  /**
   * Check whether the Payload list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasPayload() {
    return getPayloadList().getNumChild() != 0;
  }
  /**
   * Append an element to the Payload list.
   * @param node The element to append to the Payload list.
   * @apilevel high-level
   */
  public Message addPayload(Expression node) {
    List<Expression> list = (parent == null) ? getPayloadListNoTransform() : getPayloadList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Message addPayloadNoTransform(Expression node) {
    List<Expression> list = getPayloadListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Payload list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Message setPayload(Expression node, int i) {
    List<Expression> list = getPayloadList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Payload list.
   * @return The node representing the Payload list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Payload")
  public List<Expression> getPayloadList() {
    List<Expression> list = (List<Expression>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Payload list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Payload list.
   * @apilevel low-level
   */
  public List<Expression> getPayloadListNoTransform() {
    return (List<Expression>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Payload list without
   * triggering rewrites.
   */
  public Expression getPayloadNoTransform(int i) {
    return (Expression) getPayloadListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Payload list.
   * @return The node representing the Payload list.
   * @apilevel high-level
   */
  public List<Expression> getPayloads() {
    return getPayloadList();
  }
  /**
   * Retrieves the Payload list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Payload list.
   * @apilevel low-level
   */
  public List<Expression> getPayloadsNoTransform() {
    return getPayloadListNoTransform();
  }
  /**
   * @attribute inh
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:77
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:77")
  public PrettyPrinter printer() {
    ASTState state = state();
    if (printer_computed) {
      return printer_value;
    }
    if (printer_visited) {
      throw new RuntimeException("Circular definition of attribute Message.printer().");
    }
    printer_visited = true;
    state().enterLazyAttribute();
    printer_value = getParent().Define_printer(this, null);
    printer_computed = true;
    state().leaveLazyAttribute();
    printer_visited = false;
    return printer_value;
  }
/** @apilevel internal */
protected boolean printer_visited = false;
  /** @apilevel internal */
  private void printer_reset() {
    printer_computed = false;
    
    printer_value = null;
    printer_visited = false;
  }
  /** @apilevel internal */
  protected boolean printer_computed = false;

  /** @apilevel internal */
  protected PrettyPrinter printer_value;

  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:80
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getPayloadListNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:67
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return this.printer();
    }
    else if (_callerNode == getSenderNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:66
      return this.printer();
    }
    else {
      return getParent().Define_printer(this, _callerNode);
    }
  }
  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:80
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute printer
   */
  protected boolean canDefine_printer(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }

}
