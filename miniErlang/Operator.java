/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:24
 * @astdecl Operator : Expression ::= <OperatorSymbol:String> LeftOp:Expression RightOp:Expression;
 * @production Operator : {@link Expression} ::= <span class="component">&lt;OperatorSymbol:{@link String}&gt;</span> <span class="component">LeftOp:{@link Expression}</span> <span class="component">RightOp:{@link Expression}</span>;

 */
public class Operator extends Expression implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:140
   */
  public void print() {
        getLeftOp().print();
        printer().append(getOperatorSymbol());
        getRightOp().print();
    }
  /**
   * @declaredat ASTNode:1
   */
  public Operator() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"OperatorSymbol", "LeftOp", "RightOp"},
    type = {"String", "Expression", "Expression"},
    kind = {"Token", "Child", "Child"}
  )
  public Operator(String p0, Expression p1, Expression p2) {
    setOperatorSymbol(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:23
   */
  public Operator(beaver.Symbol p0, Expression p1, Expression p2) {
    setOperatorSymbol(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:29
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Operator clone() throws CloneNotSupportedException {
    Operator node = (Operator) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  public Operator copy() {
    try {
      Operator node = (Operator) clone();
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
   * @declaredat ASTNode:67
   */
  @Deprecated
  public Operator fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:77
   */
  public Operator treeCopyNoTransform() {
    Operator tree = (Operator) copy();
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
   * @declaredat ASTNode:97
   */
  public Operator treeCopy() {
    Operator tree = (Operator) copy();
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
   * Replaces the lexeme OperatorSymbol.
   * @param value The new value for the lexeme OperatorSymbol.
   * @apilevel high-level
   */
  public Operator setOperatorSymbol(String value) {
    tokenString_OperatorSymbol = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_OperatorSymbol;
  /**
   */
  public int OperatorSymbolstart;
  /**
   */
  public int OperatorSymbolend;
  /**
   * JastAdd-internal setter for lexeme OperatorSymbol using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme OperatorSymbol
   * @apilevel internal
   */
  public Operator setOperatorSymbol(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setOperatorSymbol is only valid for String lexemes");
    tokenString_OperatorSymbol = (String)symbol.value;
    OperatorSymbolstart = symbol.getStart();
    OperatorSymbolend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme OperatorSymbol.
   * @return The value for the lexeme OperatorSymbol.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="OperatorSymbol")
  public String getOperatorSymbol() {
    return tokenString_OperatorSymbol != null ? tokenString_OperatorSymbol : "";
  }
  /**
   * Replaces the LeftOp child.
   * @param node The new node to replace the LeftOp child.
   * @apilevel high-level
   */
  public Operator setLeftOp(Expression node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the LeftOp child.
   * @return The current node used as the LeftOp child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="LeftOp")
  public Expression getLeftOp() {
    return (Expression) getChild(0);
  }
  /**
   * Retrieves the LeftOp child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the LeftOp child.
   * @apilevel low-level
   */
  public Expression getLeftOpNoTransform() {
    return (Expression) getChildNoTransform(0);
  }
  /**
   * Replaces the RightOp child.
   * @param node The new node to replace the RightOp child.
   * @apilevel high-level
   */
  public Operator setRightOp(Expression node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the RightOp child.
   * @return The current node used as the RightOp child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="RightOp")
  public Expression getRightOp() {
    return (Expression) getChild(1);
  }
  /**
   * Retrieves the RightOp child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the RightOp child.
   * @apilevel low-level
   */
  public Expression getRightOpNoTransform() {
    return (Expression) getChildNoTransform(1);
  }

}
