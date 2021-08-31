/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:10
 * @astdecl ReceiveClause : ASTNode ::= Sender:Atom Label:Atom Variables:Pattern* Actions:Process;
 * @production ReceiveClause : {@link ASTNode} ::= <span class="component">Sender:{@link Atom}</span> <span class="component">Label:{@link Atom}</span> <span class="component">Variables:{@link Pattern}*</span> <span class="component">Actions:{@link Process}</span>;

 */
public class ReceiveClause extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:344
   */
  public void print(){
       printer().append(indent() + PrettyPrinter.INDENT);
       printer().append("{");
       getSender().print();
       printer().append(",");
       getLabel().print();
       if(getNumVariables()>0)
            printer().append(",");
       for(int i=0; i<getNumVariables();i++){
            getVariables(i).print();
            if(i<getNumVariables()-1){
                printer().append(",");
            }
       }
       printer().append("}->");
       getActions().print();
    }
  /**
   * @declaredat ASTNode:1
   */
  public ReceiveClause() {
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
    children = new ASTNode[4];
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Sender", "Label", "Variables", "Actions"},
    type = {"Atom", "Atom", "List<Pattern>", "Process"},
    kind = {"Child", "Child", "List", "Child"}
  )
  public ReceiveClause(Atom p0, Atom p1, List<Pattern> p2, Process p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 4;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    printer_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:40
   */
  public ReceiveClause clone() throws CloneNotSupportedException {
    ReceiveClause node = (ReceiveClause) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:45
   */
  public ReceiveClause copy() {
    try {
      ReceiveClause node = (ReceiveClause) clone();
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
   * @declaredat ASTNode:64
   */
  @Deprecated
  public ReceiveClause fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:74
   */
  public ReceiveClause treeCopyNoTransform() {
    ReceiveClause tree = (ReceiveClause) copy();
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
   * @declaredat ASTNode:94
   */
  public ReceiveClause treeCopy() {
    ReceiveClause tree = (ReceiveClause) copy();
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
   * Replaces the Sender child.
   * @param node The new node to replace the Sender child.
   * @apilevel high-level
   */
  public ReceiveClause setSender(Atom node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Sender child.
   * @return The current node used as the Sender child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Sender")
  public Atom getSender() {
    return (Atom) getChild(0);
  }
  /**
   * Retrieves the Sender child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Sender child.
   * @apilevel low-level
   */
  public Atom getSenderNoTransform() {
    return (Atom) getChildNoTransform(0);
  }
  /**
   * Replaces the Label child.
   * @param node The new node to replace the Label child.
   * @apilevel high-level
   */
  public ReceiveClause setLabel(Atom node) {
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
   * Replaces the Variables list.
   * @param list The new list node to be used as the Variables list.
   * @apilevel high-level
   */
  public ReceiveClause setVariablesList(List<Pattern> list) {
    setChild(list, 2);
    return this;
  }
  /**
   * Retrieves the number of children in the Variables list.
   * @return Number of children in the Variables list.
   * @apilevel high-level
   */
  public int getNumVariables() {
    return getVariablesList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Variables list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Variables list.
   * @apilevel low-level
   */
  public int getNumVariablesNoTransform() {
    return getVariablesListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Variables list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Variables list.
   * @apilevel high-level
   */
  public Pattern getVariables(int i) {
    return (Pattern) getVariablesList().getChild(i);
  }
  /**
   * Check whether the Variables list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasVariables() {
    return getVariablesList().getNumChild() != 0;
  }
  /**
   * Append an element to the Variables list.
   * @param node The element to append to the Variables list.
   * @apilevel high-level
   */
  public ReceiveClause addVariables(Pattern node) {
    List<Pattern> list = (parent == null) ? getVariablesListNoTransform() : getVariablesList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public ReceiveClause addVariablesNoTransform(Pattern node) {
    List<Pattern> list = getVariablesListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Variables list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public ReceiveClause setVariables(Pattern node, int i) {
    List<Pattern> list = getVariablesList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Variables list.
   * @return The node representing the Variables list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Variables")
  public List<Pattern> getVariablesList() {
    List<Pattern> list = (List<Pattern>) getChild(2);
    return list;
  }
  /**
   * Retrieves the Variables list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Variables list.
   * @apilevel low-level
   */
  public List<Pattern> getVariablesListNoTransform() {
    return (List<Pattern>) getChildNoTransform(2);
  }
  /**
   * @return the element at index {@code i} in the Variables list without
   * triggering rewrites.
   */
  public Pattern getVariablesNoTransform(int i) {
    return (Pattern) getVariablesListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Variables list.
   * @return The node representing the Variables list.
   * @apilevel high-level
   */
  public List<Pattern> getVariabless() {
    return getVariablesList();
  }
  /**
   * Retrieves the Variables list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Variables list.
   * @apilevel low-level
   */
  public List<Pattern> getVariablessNoTransform() {
    return getVariablesListNoTransform();
  }
  /**
   * Replaces the Actions child.
   * @param node The new node to replace the Actions child.
   * @apilevel high-level
   */
  public ReceiveClause setActions(Process node) {
    setChild(node, 3);
    return this;
  }
  /**
   * Retrieves the Actions child.
   * @return The current node used as the Actions child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Actions")
  public Process getActions() {
    return (Process) getChild(3);
  }
  /**
   * Retrieves the Actions child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Actions child.
   * @apilevel low-level
   */
  public Process getActionsNoTransform() {
    return (Process) getChildNoTransform(3);
  }
/** @apilevel internal */
protected boolean addsIndentationLevel_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:51
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
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:83
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:83")
  public PrettyPrinter printer() {
    ASTState state = state();
    if (printer_computed) {
      return printer_value;
    }
    if (printer_visited) {
      throw new RuntimeException("Circular definition of attribute ReceiveClause.printer().");
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

  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:78
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getActionsNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:73
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
