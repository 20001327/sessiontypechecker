/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:6
 * @astdecl Function : ASTNode ::= [Type:FunType] <FunctionName:String> Parameters:Variable* Body:Process;
 * @production Function : {@link ASTNode} ::= <span class="component">[Type:{@link FunType}]</span> <span class="component">&lt;FunctionName:{@link String}&gt;</span> <span class="component">Parameters:{@link Variable}*</span> <span class="component">Body:{@link Process}</span>;

 */
public class Function extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:118
   */
  public void print() {

        if(hasType()){
            getType().print();
        }
        printer().append("\n" + getFunctionName() + "(");
        for (int i=0; i<getNumParameters(); i++) {
            Variable var = getParameters(i);
            printer().append(var.getIdent());
            if(i<getNumParameters()-1){
                printer().append(",");
            }
        }
        printer().append(")->");
        getBody().print();
        printer().append(".");
    }
  /**
   * @declaredat ASTNode:1
   */
  public Function() {
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
    setChild(new Opt(), 0);
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Type", "FunctionName", "Parameters", "Body"},
    type = {"Opt<FunType>", "String", "List<Variable>", "Process"},
    kind = {"Opt", "Token", "List", "Child"}
  )
  public Function(Opt<FunType> p0, String p1, List<Variable> p2, Process p3) {
    setChild(p0, 0);
    setFunctionName(p1);
    setChild(p2, 1);
    setChild(p3, 2);
  }
  /**
   * @declaredat ASTNode:26
   */
  public Function(Opt<FunType> p0, beaver.Symbol p1, List<Variable> p2, Process p3) {
    setChild(p0, 0);
    setFunctionName(p1);
    setChild(p2, 1);
    setChild(p3, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:33
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    printer_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public Function clone() throws CloneNotSupportedException {
    Function node = (Function) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
   */
  public Function copy() {
    try {
      Function node = (Function) clone();
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
   * @declaredat ASTNode:71
   */
  @Deprecated
  public Function fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:81
   */
  public Function treeCopyNoTransform() {
    Function tree = (Function) copy();
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
   * @declaredat ASTNode:101
   */
  public Function treeCopy() {
    Function tree = (Function) copy();
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
   * Replaces the optional node for the Type child. This is the <code>Opt</code>
   * node containing the child Type, not the actual child!
   * @param opt The new node to be used as the optional node for the Type child.
   * @apilevel low-level
   */
  public Function setTypeOpt(Opt<FunType> opt) {
    setChild(opt, 0);
    return this;
  }
  /**
   * Replaces the (optional) Type child.
   * @param node The new node to be used as the Type child.
   * @apilevel high-level
   */
  public Function setType(FunType node) {
    getTypeOpt().setChild(node, 0);
    return this;
  }
  /**
   * Check whether the optional Type child exists.
   * @return {@code true} if the optional Type child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasType() {
    return getTypeOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Type child.
   * @return The Type child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public FunType getType() {
    return (FunType) getTypeOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Type child. This is the <code>Opt</code> node containing the child Type, not the actual child!
   * @return The optional node for child the Type child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Type")
  public Opt<FunType> getTypeOpt() {
    return (Opt<FunType>) getChild(0);
  }
  /**
   * Retrieves the optional node for child Type. This is the <code>Opt</code> node containing the child Type, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Type.
   * @apilevel low-level
   */
  public Opt<FunType> getTypeOptNoTransform() {
    return (Opt<FunType>) getChildNoTransform(0);
  }
  /**
   * Replaces the lexeme FunctionName.
   * @param value The new value for the lexeme FunctionName.
   * @apilevel high-level
   */
  public Function setFunctionName(String value) {
    tokenString_FunctionName = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_FunctionName;
  /**
   */
  public int FunctionNamestart;
  /**
   */
  public int FunctionNameend;
  /**
   * JastAdd-internal setter for lexeme FunctionName using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FunctionName
   * @apilevel internal
   */
  public Function setFunctionName(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFunctionName is only valid for String lexemes");
    tokenString_FunctionName = (String)symbol.value;
    FunctionNamestart = symbol.getStart();
    FunctionNameend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme FunctionName.
   * @return The value for the lexeme FunctionName.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FunctionName")
  public String getFunctionName() {
    return tokenString_FunctionName != null ? tokenString_FunctionName : "";
  }
  /**
   * Replaces the Parameters list.
   * @param list The new list node to be used as the Parameters list.
   * @apilevel high-level
   */
  public Function setParametersList(List<Variable> list) {
    setChild(list, 1);
    return this;
  }
  /**
   * Retrieves the number of children in the Parameters list.
   * @return Number of children in the Parameters list.
   * @apilevel high-level
   */
  public int getNumParameters() {
    return getParametersList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Parameters list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Parameters list.
   * @apilevel low-level
   */
  public int getNumParametersNoTransform() {
    return getParametersListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Parameters list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Parameters list.
   * @apilevel high-level
   */
  public Variable getParameters(int i) {
    return (Variable) getParametersList().getChild(i);
  }
  /**
   * Check whether the Parameters list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasParameters() {
    return getParametersList().getNumChild() != 0;
  }
  /**
   * Append an element to the Parameters list.
   * @param node The element to append to the Parameters list.
   * @apilevel high-level
   */
  public Function addParameters(Variable node) {
    List<Variable> list = (parent == null) ? getParametersListNoTransform() : getParametersList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Function addParametersNoTransform(Variable node) {
    List<Variable> list = getParametersListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Parameters list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Function setParameters(Variable node, int i) {
    List<Variable> list = getParametersList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Parameters list.
   * @return The node representing the Parameters list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Parameters")
  public List<Variable> getParametersList() {
    List<Variable> list = (List<Variable>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Parameters list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Parameters list.
   * @apilevel low-level
   */
  public List<Variable> getParametersListNoTransform() {
    return (List<Variable>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Parameters list without
   * triggering rewrites.
   */
  public Variable getParametersNoTransform(int i) {
    return (Variable) getParametersListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Parameters list.
   * @return The node representing the Parameters list.
   * @apilevel high-level
   */
  public List<Variable> getParameterss() {
    return getParametersList();
  }
  /**
   * Retrieves the Parameters list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Parameters list.
   * @apilevel low-level
   */
  public List<Variable> getParameterssNoTransform() {
    return getParametersListNoTransform();
  }
  /**
   * Replaces the Body child.
   * @param node The new node to replace the Body child.
   * @apilevel high-level
   */
  public Function setBody(Process node) {
    setChild(node, 2);
    return this;
  }
  /**
   * Retrieves the Body child.
   * @return The current node used as the Body child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Body")
  public Process getBody() {
    return (Process) getChild(2);
  }
  /**
   * Retrieves the Body child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Body child.
   * @apilevel low-level
   */
  public Process getBodyNoTransform() {
    return (Process) getChildNoTransform(2);
  }
/** @apilevel internal */
protected boolean addsIndentationLevel_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:49
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
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:77
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:77")
  public PrettyPrinter printer() {
    ASTState state = state();
    if (printer_computed) {
      return printer_value;
    }
    if (printer_visited) {
      throw new RuntimeException("Circular definition of attribute Function.printer().");
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
    if (_callerNode == getTypeOptNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:62
      return this.printer();
    }
    else if (_callerNode == getBodyNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:61
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
