/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:18
 * @astdecl ExpressionProcess : Process ::= Expression:Expression [Next:Process];
 * @production ExpressionProcess : {@link Process} ::= <span class="component">Expression:{@link Expression}</span> <span class="component">[Next:{@link Process}]</span>;

 */
public class ExpressionProcess extends Process implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:418
   */
  public void print(){
       printer().append(indent());
       getExpression().print();
       if(hasNext()){
           printer().append(",");
           getNext().print();
       }
    }
  /**
   * @declaredat ASTNode:1
   */
  public ExpressionProcess() {
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
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Expression", "Next"},
    type = {"Expression", "Opt<Process>"},
    kind = {"Child", "Opt"}
  )
  public ExpressionProcess(Expression p0, Opt<Process> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public ExpressionProcess clone() throws CloneNotSupportedException {
    ExpressionProcess node = (ExpressionProcess) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public ExpressionProcess copy() {
    try {
      ExpressionProcess node = (ExpressionProcess) clone();
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
   * @declaredat ASTNode:62
   */
  @Deprecated
  public ExpressionProcess fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public ExpressionProcess treeCopyNoTransform() {
    ExpressionProcess tree = (ExpressionProcess) copy();
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
   * @declaredat ASTNode:92
   */
  public ExpressionProcess treeCopy() {
    ExpressionProcess tree = (ExpressionProcess) copy();
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
   * Replaces the Expression child.
   * @param node The new node to replace the Expression child.
   * @apilevel high-level
   */
  public ExpressionProcess setExpression(Expression node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Expression child.
   * @return The current node used as the Expression child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expression")
  public Expression getExpression() {
    return (Expression) getChild(0);
  }
  /**
   * Retrieves the Expression child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expression child.
   * @apilevel low-level
   */
  public Expression getExpressionNoTransform() {
    return (Expression) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the Next child. This is the <code>Opt</code>
   * node containing the child Next, not the actual child!
   * @param opt The new node to be used as the optional node for the Next child.
   * @apilevel low-level
   */
  public ExpressionProcess setNextOpt(Opt<Process> opt) {
    setChild(opt, 1);
    return this;
  }
  /**
   * Replaces the (optional) Next child.
   * @param node The new node to be used as the Next child.
   * @apilevel high-level
   */
  public ExpressionProcess setNext(Process node) {
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
/** @apilevel internal */
protected boolean addsIndentationLevel_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:53
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:46")
  public boolean addsIndentationLevel() {
    if (addsIndentationLevel_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.addsIndentationLevel().");
    }
    addsIndentationLevel_visited = true;
    boolean addsIndentationLevel_value = true;
    addsIndentationLevel_visited = false;
    return addsIndentationLevel_value;
  }

}
