/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:15
 * @astdecl Receive : Process ::= Clauses:ReceiveClause* [Next:Process];
 * @production Receive : {@link Process} ::= <span class="component">Clauses:{@link ReceiveClause}*</span> <span class="component">[Next:{@link Process}]</span>;

 */
public class Receive extends Process implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:305
   */
  public void print() {
        printer().append(indent());
        printer().append("receive");
        for(int i=0; i<getNumClauses();i++){
            getClauses(i).print();
            if(i<getNumClauses()-1){
                printer().append(";");
            }
        }
        printer().append(indent() + "end");
        if(hasNext()){
            printer().append(",");
            getNext().print();
        }
    }
  /**
   * @declaredat ASTNode:1
   */
  public Receive() {
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
    setChild(new List(), 0);
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Clauses", "Next"},
    type = {"List<ReceiveClause>", "Opt<Process>"},
    kind = {"List", "Opt"}
  )
  public Receive(List<ReceiveClause> p0, Opt<Process> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:25
   */
  protected int numChildren() {
    return 2;
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
  public Receive clone() throws CloneNotSupportedException {
    Receive node = (Receive) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public Receive copy() {
    try {
      Receive node = (Receive) clone();
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
  public Receive fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public Receive treeCopyNoTransform() {
    Receive tree = (Receive) copy();
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
  public Receive treeCopy() {
    Receive tree = (Receive) copy();
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
   * Replaces the Clauses list.
   * @param list The new list node to be used as the Clauses list.
   * @apilevel high-level
   */
  public Receive setClausesList(List<ReceiveClause> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Clauses list.
   * @return Number of children in the Clauses list.
   * @apilevel high-level
   */
  public int getNumClauses() {
    return getClausesList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Clauses list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Clauses list.
   * @apilevel low-level
   */
  public int getNumClausesNoTransform() {
    return getClausesListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Clauses list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Clauses list.
   * @apilevel high-level
   */
  public ReceiveClause getClauses(int i) {
    return (ReceiveClause) getClausesList().getChild(i);
  }
  /**
   * Check whether the Clauses list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasClauses() {
    return getClausesList().getNumChild() != 0;
  }
  /**
   * Append an element to the Clauses list.
   * @param node The element to append to the Clauses list.
   * @apilevel high-level
   */
  public Receive addClauses(ReceiveClause node) {
    List<ReceiveClause> list = (parent == null) ? getClausesListNoTransform() : getClausesList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Receive addClausesNoTransform(ReceiveClause node) {
    List<ReceiveClause> list = getClausesListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Clauses list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Receive setClauses(ReceiveClause node, int i) {
    List<ReceiveClause> list = getClausesList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Clauses list.
   * @return The node representing the Clauses list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Clauses")
  public List<ReceiveClause> getClausesList() {
    List<ReceiveClause> list = (List<ReceiveClause>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Clauses list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Clauses list.
   * @apilevel low-level
   */
  public List<ReceiveClause> getClausesListNoTransform() {
    return (List<ReceiveClause>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Clauses list without
   * triggering rewrites.
   */
  public ReceiveClause getClausesNoTransform(int i) {
    return (ReceiveClause) getClausesListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Clauses list.
   * @return The node representing the Clauses list.
   * @apilevel high-level
   */
  public List<ReceiveClause> getClausess() {
    return getClausesList();
  }
  /**
   * Retrieves the Clauses list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Clauses list.
   * @apilevel low-level
   */
  public List<ReceiveClause> getClausessNoTransform() {
    return getClausesListNoTransform();
  }
  /**
   * Replaces the optional node for the Next child. This is the <code>Opt</code>
   * node containing the child Next, not the actual child!
   * @param opt The new node to be used as the optional node for the Next child.
   * @apilevel low-level
   */
  public Receive setNextOpt(Opt<Process> opt) {
    setChild(opt, 1);
    return this;
  }
  /**
   * Replaces the (optional) Next child.
   * @param node The new node to be used as the Next child.
   * @apilevel high-level
   */
  public Receive setNext(Process node) {
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
    return (Opt<Process>) getChild(1);
  }
  /**
   * Retrieves the optional node for child Next. This is the <code>Opt</code> node containing the child Next, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Next.
   * @apilevel low-level
   */
  public Opt<Process> getNextOptNoTransform() {
    return (Opt<Process>) getChildNoTransform(1);
  }
  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:78
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getClausesListNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:71
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return this.printer();
    }
    else if (_callerNode == getNextOptNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:65
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
