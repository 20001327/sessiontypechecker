/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:13
 * @astdecl CaseClause : Term ::= Patterns:Pattern* Actions:Process;
 * @production CaseClause : {@link Term} ::= <span class="component">Patterns:{@link Pattern}*</span> <span class="component">Actions:{@link Process}</span>;

 */
public class CaseClause extends Term implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:232
   */
  public void print(){
       printer().append(indent() + PrettyPrinter.INDENT);
       for(int i=0; i<getNumPatterns();i++){
            getPatterns(i).print();
            if(i<getNumPatterns()-1){
                printer().append(",");
            }
       }
       printer().append(" -> ");
       getActions().print();
    }
  /**
   * @declaredat ASTNode:1
   */
  public CaseClause() {
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
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Patterns", "Actions"},
    type = {"List<Pattern>", "Process"},
    kind = {"List", "Child"}
  )
  public CaseClause(List<Pattern> p0, Process p1) {
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
    printer_reset();
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
  public CaseClause clone() throws CloneNotSupportedException {
    CaseClause node = (CaseClause) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public CaseClause copy() {
    try {
      CaseClause node = (CaseClause) clone();
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
  public CaseClause fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public CaseClause treeCopyNoTransform() {
    CaseClause tree = (CaseClause) copy();
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
  public CaseClause treeCopy() {
    CaseClause tree = (CaseClause) copy();
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
   * Replaces the Patterns list.
   * @param list The new list node to be used as the Patterns list.
   * @apilevel high-level
   */
  public CaseClause setPatternsList(List<Pattern> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Patterns list.
   * @return Number of children in the Patterns list.
   * @apilevel high-level
   */
  public int getNumPatterns() {
    return getPatternsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Patterns list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Patterns list.
   * @apilevel low-level
   */
  public int getNumPatternsNoTransform() {
    return getPatternsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Patterns list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Patterns list.
   * @apilevel high-level
   */
  public Pattern getPatterns(int i) {
    return (Pattern) getPatternsList().getChild(i);
  }
  /**
   * Check whether the Patterns list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasPatterns() {
    return getPatternsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Patterns list.
   * @param node The element to append to the Patterns list.
   * @apilevel high-level
   */
  public CaseClause addPatterns(Pattern node) {
    List<Pattern> list = (parent == null) ? getPatternsListNoTransform() : getPatternsList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public CaseClause addPatternsNoTransform(Pattern node) {
    List<Pattern> list = getPatternsListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Patterns list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public CaseClause setPatterns(Pattern node, int i) {
    List<Pattern> list = getPatternsList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Patterns list.
   * @return The node representing the Patterns list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Patterns")
  public List<Pattern> getPatternsList() {
    List<Pattern> list = (List<Pattern>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Patterns list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Patterns list.
   * @apilevel low-level
   */
  public List<Pattern> getPatternsListNoTransform() {
    return (List<Pattern>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Patterns list without
   * triggering rewrites.
   */
  public Pattern getPatternsNoTransform(int i) {
    return (Pattern) getPatternsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Patterns list.
   * @return The node representing the Patterns list.
   * @apilevel high-level
   */
  public List<Pattern> getPatternss() {
    return getPatternsList();
  }
  /**
   * Retrieves the Patterns list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Patterns list.
   * @apilevel low-level
   */
  public List<Pattern> getPatternssNoTransform() {
    return getPatternsListNoTransform();
  }
  /**
   * Replaces the Actions child.
   * @param node The new node to replace the Actions child.
   * @apilevel high-level
   */
  public CaseClause setActions(Process node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Actions child.
   * @return The current node used as the Actions child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Actions")
  public Process getActions() {
    return (Process) getChild(1);
  }
  /**
   * Retrieves the Actions child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Actions child.
   * @apilevel low-level
   */
  public Process getActionsNoTransform() {
    return (Process) getChildNoTransform(1);
  }
/** @apilevel internal */
protected boolean addsIndentationLevel_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:52
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
  /**
   * @attribute inh
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:79
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:79")
  public PrettyPrinter printer() {
    ASTState state = state();
    if (printer_computed) {
      return printer_value;
    }
    if (printer_visited) {
      throw new RuntimeException("Circular definition of attribute CaseClause.printer().");
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


}
