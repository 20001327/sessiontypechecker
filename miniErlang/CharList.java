/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:32
 * @astdecl CharList : Literal ::= <StringValue:String>;
 * @production CharList : {@link Literal} ::= <span class="component">&lt;StringValue:{@link String}&gt;</span>;

 */
public class CharList extends Literal implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:297
   */
  public void print() {
        printer().append(getStringValue());
    }
  /**
   * @declaredat ASTNode:1
   */
  public CharList() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"StringValue"},
    type = {"String"},
    kind = {"Token"}
  )
  public CharList(String p0) {
    setStringValue(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public CharList(beaver.Symbol p0) {
    setStringValue(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
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
  public CharList clone() throws CloneNotSupportedException {
    CharList node = (CharList) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public CharList copy() {
    try {
      CharList node = (CharList) clone();
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
  public CharList fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public CharList treeCopyNoTransform() {
    CharList tree = (CharList) copy();
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
  public CharList treeCopy() {
    CharList tree = (CharList) copy();
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
   * Replaces the lexeme StringValue.
   * @param value The new value for the lexeme StringValue.
   * @apilevel high-level
   */
  public CharList setStringValue(String value) {
    tokenString_StringValue = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_StringValue;
  /**
   */
  public int StringValuestart;
  /**
   */
  public int StringValueend;
  /**
   * JastAdd-internal setter for lexeme StringValue using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme StringValue
   * @apilevel internal
   */
  public CharList setStringValue(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setStringValue is only valid for String lexemes");
    tokenString_StringValue = (String)symbol.value;
    StringValuestart = symbol.getStart();
    StringValueend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme StringValue.
   * @return The value for the lexeme StringValue.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="StringValue")
  public String getStringValue() {
    return tokenString_StringValue != null ? tokenString_StringValue : "";
  }

}
