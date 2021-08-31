/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:14
 * @astdecl Send : Process ::= Recipient:Atom Message:Message [Next:Process];
 * @production Send : {@link Process} ::= <span class="component">Recipient:{@link Atom}</span> <span class="component">Message:{@link Message}</span> <span class="component">[Next:{@link Process}]</span>;

 */
public class Send extends Process implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:248
   */
  public void print() {
        printer().append(indent());
        getRecipient().print();
        printer().append("!");
        getMessage().print();
        if(hasNext()){
            printer().append(",");
            getNext().print();
        }
    }
  /**
   * @declaredat ASTNode:1
   */
  public Send() {
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
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Recipient", "Message", "Next"},
    type = {"Atom", "Message", "Opt<Process>"},
    kind = {"Child", "Child", "Opt"}
  )
  public Send(Atom p0, Message p1, Opt<Process> p2) {
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
  public Send clone() throws CloneNotSupportedException {
    Send node = (Send) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public Send copy() {
    try {
      Send node = (Send) clone();
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
  public Send fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public Send treeCopyNoTransform() {
    Send tree = (Send) copy();
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
  public Send treeCopy() {
    Send tree = (Send) copy();
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
  public Send setRecipient(Atom node) {
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
   * Replaces the Message child.
   * @param node The new node to replace the Message child.
   * @apilevel high-level
   */
  public Send setMessage(Message node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Message child.
   * @return The current node used as the Message child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Message")
  public Message getMessage() {
    return (Message) getChild(1);
  }
  /**
   * Retrieves the Message child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Message child.
   * @apilevel low-level
   */
  public Message getMessageNoTransform() {
    return (Message) getChildNoTransform(1);
  }
  /**
   * Replaces the optional node for the Next child. This is the <code>Opt</code>
   * node containing the child Next, not the actual child!
   * @param opt The new node to be used as the optional node for the Next child.
   * @apilevel low-level
   */
  public Send setNextOpt(Opt<Process> opt) {
    setChild(opt, 2);
    return this;
  }
  /**
   * Replaces the (optional) Next child.
   * @param node The new node to be used as the Next child.
   * @apilevel high-level
   */
  public Send setNext(Process node) {
    getNextOpt().setChild(node, 0);
    return this;
  }
  /**
   * Check whether the optional Next child exists.
   * @return {@code true} if the optional Next child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasNext() {
    return getNextOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Next child.
   * @return The Next child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Process getNext() {
    return (Process) getNextOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Next child. This is the <code>Opt</code> node containing the child Next, not the actual child!
   * @return The optional node for child the Next child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Next")
  public Opt<Process> getNextOpt() {
    return (Opt<Process>) getChild(2);
  }
  /**
   * Retrieves the optional node for child Next. This is the <code>Opt</code> node containing the child Next, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Next.
   * @apilevel low-level
   */
  public Opt<Process> getNextOptNoTransform() {
    return (Opt<Process>) getChildNoTransform(2);
  }
  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:78
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getMessageNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:68
      return this.printer();
    }
    else if (_callerNode == getRecipientNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:67
      return this.printer();
    }
    else if (_callerNode == getNextOptNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:66
      return this.printer();
    }
    else {
      return getParent().Define_printer(this, _callerNode);
    }
  }
  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:78
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute printer
   */
  protected boolean canDefine_printer(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }

}
