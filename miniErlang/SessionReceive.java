/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:54
 * @astdecl SessionReceive : Term ::= Recipient:Atom Label:Atom <Type:String> Next:Session;
 * @production SessionReceive : {@link Term} ::= <span class="component">Recipient:{@link Atom}</span> <span class="component">Label:{@link Atom}</span> <span class="component">&lt;Type:{@link String}&gt;</span> <span class="component">Next:{@link Session}</span>;

 */
public class SessionReceive extends Term implements Cloneable {
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
    children = new ASTNode[3];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Recipient", "Label", "Type", "Next"},
    type = {"Atom", "Atom", "String", "Session"},
    kind = {"Child", "Child", "Token", "Child"}
  )
  public SessionReceive(Atom p0, Atom p1, String p2, Session p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setType(p2);
    setChild(p3, 2);
  }
  /**
   * @declaredat ASTNode:24
   */
  public SessionReceive(Atom p0, Atom p1, beaver.Symbol p2, Session p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setType(p2);
    setChild(p3, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:31
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
   */
  public SessionReceive clone() throws CloneNotSupportedException {
    SessionReceive node = (SessionReceive) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:50
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
   * @declaredat ASTNode:69
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
   * @declaredat ASTNode:79
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
   * @declaredat ASTNode:99
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
   * Replaces the lexeme Type.
   * @param value The new value for the lexeme Type.
   * @apilevel high-level
   */
  public SessionReceive setType(String value) {
    tokenString_Type = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_Type;
  /**
   */
  public int Typestart;
  /**
   */
  public int Typeend;
  /**
   * JastAdd-internal setter for lexeme Type using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Type
   * @apilevel internal
   */
  public SessionReceive setType(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setType is only valid for String lexemes");
    tokenString_Type = (String)symbol.value;
    Typestart = symbol.getStart();
    Typeend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme Type.
   * @return The value for the lexeme Type.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Type")
  public String getType() {
    return tokenString_Type != null ? tokenString_Type : "";
  }
  /**
   * Replaces the Next child.
   * @param node The new node to replace the Next child.
   * @apilevel high-level
   */
  public SessionReceive setNext(Session node) {
    setChild(node, 2);
    return this;
  }
  /**
   * Retrieves the Next child.
   * @return The current node used as the Next child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Next")
  public Session getNext() {
    return (Session) getChild(2);
  }
  /**
   * Retrieves the Next child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Next child.
   * @apilevel low-level
   */
  public Session getNextNoTransform() {
    return (Session) getChildNoTransform(2);
  }

}
