/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:19
 * @astdecl Let : Process ::= Left:Variable Right:Expression Next:Process;
 * @production Let : {@link Process} ::= <span class="component">Left:{@link Variable}</span> <span class="component">Right:{@link Expression}</span> <span class="component">Next:{@link Process}</span>;

 */
public class Let extends Process implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:244
   */
  public void print(){
        printer().append(indent());
        getLeft().print();
        printer().append("=");
        getRight().print();
        printer().append(",");
        getNext().print();
    }
  /**
   * @declaredat ASTNode:1
   */
  public Let() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Left", "Right", "Next"},
    type = {"Variable", "Expression", "Process"},
    kind = {"Child", "Child", "Child"}
  )
  public Let(Variable p0, Expression p1, Process p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 3;
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
  public Let clone() throws CloneNotSupportedException {
    Let node = (Let) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Let copy() {
    try {
      Let node = (Let) clone();
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
  public Let fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Let treeCopyNoTransform() {
    Let tree = (Let) copy();
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
  public Let treeCopy() {
    Let tree = (Let) copy();
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
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public Let setLeft(Variable node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public Variable getLeft() {
    return (Variable) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public Variable getLeftNoTransform() {
    return (Variable) getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   */
  public Let setRight(Expression node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Right")
  public Expression getRight() {
    return (Expression) getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   */
  public Expression getRightNoTransform() {
    return (Expression) getChildNoTransform(1);
  }
  /**
   * Replaces the Next child.
   * @param node The new node to replace the Next child.
   * @apilevel high-level
   */
  public Let setNext(Process node) {
    setChild(node, 2);
    return this;
  }
  /**
   * Retrieves the Next child.
   * @return The current node used as the Next child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Next")
  public Process getNext() {
    return (Process) getChild(2);
  }
  /**
   * Retrieves the Next child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Next child.
   * @apilevel low-level
   */
  public Process getNextNoTransform() {
    return (Process) getChildNoTransform(2);
  }
  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:80
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getNextNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:71
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
