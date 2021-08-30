/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:25
 * @astdecl Call : Expression ::= FunctionName:Atom Arguments:Expression*;
 * @production Call : {@link Expression} ::= <span class="component">FunctionName:{@link Atom}</span> <span class="component">Arguments:{@link Expression}*</span>;

 */
public class Call extends Expression implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:252
   */
  public void print(){
        getFunctionName().print();
        printer().append("(");
       for(int i=0; i<getNumArguments();i++){
            getArguments(i).print();
            if(i<getNumArguments()-1){
                printer().append(",");
            }
       }
       printer().append(")");
    }
  /**
   * @declaredat ASTNode:1
   */
  public Call() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"FunctionName", "Arguments"},
    type = {"Atom", "List<Expression>"},
    kind = {"Child", "List"}
  )
  public Call(Atom p0, List<Expression> p1) {
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
  public Call clone() throws CloneNotSupportedException {
    Call node = (Call) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Call copy() {
    try {
      Call node = (Call) clone();
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
  public Call fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Call treeCopyNoTransform() {
    Call tree = (Call) copy();
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
  public Call treeCopy() {
    Call tree = (Call) copy();
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
   * Replaces the FunctionName child.
   * @param node The new node to replace the FunctionName child.
   * @apilevel high-level
   */
  public Call setFunctionName(Atom node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the FunctionName child.
   * @return The current node used as the FunctionName child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FunctionName")
  public Atom getFunctionName() {
    return (Atom) getChild(0);
  }
  /**
   * Retrieves the FunctionName child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FunctionName child.
   * @apilevel low-level
   */
  public Atom getFunctionNameNoTransform() {
    return (Atom) getChildNoTransform(0);
  }
  /**
   * Replaces the Arguments list.
   * @param list The new list node to be used as the Arguments list.
   * @apilevel high-level
   */
  public Call setArgumentsList(List<Expression> list) {
    setChild(list, 1);
    return this;
  }
  /**
   * Retrieves the number of children in the Arguments list.
   * @return Number of children in the Arguments list.
   * @apilevel high-level
   */
  public int getNumArguments() {
    return getArgumentsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Arguments list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Arguments list.
   * @apilevel low-level
   */
  public int getNumArgumentsNoTransform() {
    return getArgumentsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Arguments list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Arguments list.
   * @apilevel high-level
   */
  public Expression getArguments(int i) {
    return (Expression) getArgumentsList().getChild(i);
  }
  /**
   * Check whether the Arguments list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasArguments() {
    return getArgumentsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Arguments list.
   * @param node The element to append to the Arguments list.
   * @apilevel high-level
   */
  public Call addArguments(Expression node) {
    List<Expression> list = (parent == null) ? getArgumentsListNoTransform() : getArgumentsList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Call addArgumentsNoTransform(Expression node) {
    List<Expression> list = getArgumentsListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Arguments list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Call setArguments(Expression node, int i) {
    List<Expression> list = getArgumentsList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Arguments list.
   * @return The node representing the Arguments list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Arguments")
  public List<Expression> getArgumentsList() {
    List<Expression> list = (List<Expression>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Arguments list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arguments list.
   * @apilevel low-level
   */
  public List<Expression> getArgumentsListNoTransform() {
    return (List<Expression>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Arguments list without
   * triggering rewrites.
   */
  public Expression getArgumentsNoTransform(int i) {
    return (Expression) getArgumentsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Arguments list.
   * @return The node representing the Arguments list.
   * @apilevel high-level
   */
  public List<Expression> getArgumentss() {
    return getArgumentsList();
  }
  /**
   * Retrieves the Arguments list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arguments list.
   * @apilevel low-level
   */
  public List<Expression> getArgumentssNoTransform() {
    return getArgumentsListNoTransform();
  }

}
