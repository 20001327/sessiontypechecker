/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:18
 * @astdecl Case : Process ::= Matching:Expression* Clauses:CaseClause* [Next:Process];
 * @production Case : {@link Process} ::= <span class="component">Matching:{@link Expression}*</span> <span class="component">Clauses:{@link CaseClause}*</span> <span class="component">[Next:{@link Process}]</span>;

 */
public class Case extends Process implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:191
   */
  public void print() {
        printer().append(indent());
        printer().append("case ");
        for(int i=0; i<getNumMatching();i++){
            getMatching(i).print();
            if(i<getNumMatching()-1){
                printer().append(",");
            }
        }
        printer().append(" of ");
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
  public Case() {
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
    setChild(new List(), 0);
    setChild(new List(), 1);
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:16
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Matching", "Clauses", "Next"},
    type = {"List<Expression>", "List<CaseClause>", "Opt<Process>"},
    kind = {"List", "List", "Opt"}
  )
  public Case(List<Expression> p0, List<CaseClause> p1, Opt<Process> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:27
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Case clone() throws CloneNotSupportedException {
    Case node = (Case) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:46
   */
  public Case copy() {
    try {
      Case node = (Case) clone();
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
   * @declaredat ASTNode:65
   */
  @Deprecated
  public Case fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public Case treeCopyNoTransform() {
    Case tree = (Case) copy();
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
   * @declaredat ASTNode:95
   */
  public Case treeCopy() {
    Case tree = (Case) copy();
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
   * Replaces the Matching list.
   * @param list The new list node to be used as the Matching list.
   * @apilevel high-level
   */
  public Case setMatchingList(List<Expression> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Matching list.
   * @return Number of children in the Matching list.
   * @apilevel high-level
   */
  public int getNumMatching() {
    return getMatchingList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Matching list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Matching list.
   * @apilevel low-level
   */
  public int getNumMatchingNoTransform() {
    return getMatchingListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Matching list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Matching list.
   * @apilevel high-level
   */
  public Expression getMatching(int i) {
    return (Expression) getMatchingList().getChild(i);
  }
  /**
   * Check whether the Matching list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasMatching() {
    return getMatchingList().getNumChild() != 0;
  }
  /**
   * Append an element to the Matching list.
   * @param node The element to append to the Matching list.
   * @apilevel high-level
   */
  public Case addMatching(Expression node) {
    List<Expression> list = (parent == null) ? getMatchingListNoTransform() : getMatchingList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Case addMatchingNoTransform(Expression node) {
    List<Expression> list = getMatchingListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Matching list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Case setMatching(Expression node, int i) {
    List<Expression> list = getMatchingList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Matching list.
   * @return The node representing the Matching list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Matching")
  public List<Expression> getMatchingList() {
    List<Expression> list = (List<Expression>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Matching list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Matching list.
   * @apilevel low-level
   */
  public List<Expression> getMatchingListNoTransform() {
    return (List<Expression>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Matching list without
   * triggering rewrites.
   */
  public Expression getMatchingNoTransform(int i) {
    return (Expression) getMatchingListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Matching list.
   * @return The node representing the Matching list.
   * @apilevel high-level
   */
  public List<Expression> getMatchings() {
    return getMatchingList();
  }
  /**
   * Retrieves the Matching list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Matching list.
   * @apilevel low-level
   */
  public List<Expression> getMatchingsNoTransform() {
    return getMatchingListNoTransform();
  }
  /**
   * Replaces the Clauses list.
   * @param list The new list node to be used as the Clauses list.
   * @apilevel high-level
   */
  public Case setClausesList(List<CaseClause> list) {
    setChild(list, 1);
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
  public CaseClause getClauses(int i) {
    return (CaseClause) getClausesList().getChild(i);
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
  public Case addClauses(CaseClause node) {
    List<CaseClause> list = (parent == null) ? getClausesListNoTransform() : getClausesList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Case addClausesNoTransform(CaseClause node) {
    List<CaseClause> list = getClausesListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Clauses list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Case setClauses(CaseClause node, int i) {
    List<CaseClause> list = getClausesList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Clauses list.
   * @return The node representing the Clauses list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Clauses")
  public List<CaseClause> getClausesList() {
    List<CaseClause> list = (List<CaseClause>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Clauses list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Clauses list.
   * @apilevel low-level
   */
  public List<CaseClause> getClausesListNoTransform() {
    return (List<CaseClause>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Clauses list without
   * triggering rewrites.
   */
  public CaseClause getClausesNoTransform(int i) {
    return (CaseClause) getClausesListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Clauses list.
   * @return The node representing the Clauses list.
   * @apilevel high-level
   */
  public List<CaseClause> getClausess() {
    return getClausesList();
  }
  /**
   * Retrieves the Clauses list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Clauses list.
   * @apilevel low-level
   */
  public List<CaseClause> getClausessNoTransform() {
    return getClausesListNoTransform();
  }
  /**
   * Replaces the optional node for the Next child. This is the <code>Opt</code>
   * node containing the child Next, not the actual child!
   * @param opt The new node to be used as the optional node for the Next child.
   * @apilevel low-level
   */
  public Case setNextOpt(Opt<Process> opt) {
    setChild(opt, 2);
    return this;
  }
  /**
   * Replaces the (optional) Next child.
   * @param node The new node to be used as the Next child.
   * @apilevel high-level
   */
  public Case setNext(Process node) {
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
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:80
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getClausesListNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:69
      int childIndex = _callerNode.getIndexOfChild(_childNode);
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
