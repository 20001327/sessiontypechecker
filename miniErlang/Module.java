/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:4
 * @astdecl Module : ASTNode ::= <Partecipant:String> <RegisteredName:String> <ModuleName:String> <FunName:String> Functions:Function*;
 * @production Module : {@link ASTNode} ::= <span class="component">&lt;Partecipant:{@link String}&gt;</span> <span class="component">&lt;RegisteredName:{@link String}&gt;</span> <span class="component">&lt;ModuleName:{@link String}&gt;</span> <span class="component">&lt;FunName:{@link String}&gt;</span> <span class="component">Functions:{@link Function}*</span>;

 */
public class Module extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:90
   */
  public void print() {
        printer().append("-module(" + getPartecipant() + "). \n");
        printer().append("-export([start/0,");
        for (int i=0; i<getFunctionss().getNumChild(); i++) {
            Function f = getFunctions(i);
            printer().append(f.getFunctionName() + "/");
            printer().append(f.getNumParameters() + "");
            if(i<getFunctionss().getNumChild()-1){
                printer().append(",");
            }
        }
        printer().append("]).\n");

        printer().append("start() -> register(" + getRegisteredName() +
                        ",spawn("+ getModuleName() +", " + getFunName() + ", []);");


        for (Function f : getFunctionss()) {
            f.print();
        }

    }
  /**
   * @declaredat ASTNode:1
   */
  public Module() {
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
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Partecipant", "RegisteredName", "ModuleName", "FunName", "Functions"},
    type = {"String", "String", "String", "String", "List<Function>"},
    kind = {"Token", "Token", "Token", "Token", "List"}
  )
  public Module(String p0, String p1, String p2, String p3, List<Function> p4) {
    setPartecipant(p0);
    setRegisteredName(p1);
    setModuleName(p2);
    setFunName(p3);
    setChild(p4, 0);
  }
  /**
   * @declaredat ASTNode:26
   */
  public Module(beaver.Symbol p0, beaver.Symbol p1, beaver.Symbol p2, beaver.Symbol p3, List<Function> p4) {
    setPartecipant(p0);
    setRegisteredName(p1);
    setModuleName(p2);
    setFunName(p3);
    setChild(p4, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:34
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    printer_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  public Module clone() throws CloneNotSupportedException {
    Module node = (Module) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:53
   */
  public Module copy() {
    try {
      Module node = (Module) clone();
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
   * @declaredat ASTNode:72
   */
  @Deprecated
  public Module fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:82
   */
  public Module treeCopyNoTransform() {
    Module tree = (Module) copy();
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
   * @declaredat ASTNode:102
   */
  public Module treeCopy() {
    Module tree = (Module) copy();
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
   * Replaces the lexeme Partecipant.
   * @param value The new value for the lexeme Partecipant.
   * @apilevel high-level
   */
  public Module setPartecipant(String value) {
    tokenString_Partecipant = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_Partecipant;
  /**
   */
  public int Partecipantstart;
  /**
   */
  public int Partecipantend;
  /**
   * JastAdd-internal setter for lexeme Partecipant using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Partecipant
   * @apilevel internal
   */
  public Module setPartecipant(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setPartecipant is only valid for String lexemes");
    tokenString_Partecipant = (String)symbol.value;
    Partecipantstart = symbol.getStart();
    Partecipantend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme Partecipant.
   * @return The value for the lexeme Partecipant.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Partecipant")
  public String getPartecipant() {
    return tokenString_Partecipant != null ? tokenString_Partecipant : "";
  }
  /**
   * Replaces the lexeme RegisteredName.
   * @param value The new value for the lexeme RegisteredName.
   * @apilevel high-level
   */
  public Module setRegisteredName(String value) {
    tokenString_RegisteredName = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_RegisteredName;
  /**
   */
  public int RegisteredNamestart;
  /**
   */
  public int RegisteredNameend;
  /**
   * JastAdd-internal setter for lexeme RegisteredName using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme RegisteredName
   * @apilevel internal
   */
  public Module setRegisteredName(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setRegisteredName is only valid for String lexemes");
    tokenString_RegisteredName = (String)symbol.value;
    RegisteredNamestart = symbol.getStart();
    RegisteredNameend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme RegisteredName.
   * @return The value for the lexeme RegisteredName.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="RegisteredName")
  public String getRegisteredName() {
    return tokenString_RegisteredName != null ? tokenString_RegisteredName : "";
  }
  /**
   * Replaces the lexeme ModuleName.
   * @param value The new value for the lexeme ModuleName.
   * @apilevel high-level
   */
  public Module setModuleName(String value) {
    tokenString_ModuleName = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ModuleName;
  /**
   */
  public int ModuleNamestart;
  /**
   */
  public int ModuleNameend;
  /**
   * JastAdd-internal setter for lexeme ModuleName using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ModuleName
   * @apilevel internal
   */
  public Module setModuleName(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setModuleName is only valid for String lexemes");
    tokenString_ModuleName = (String)symbol.value;
    ModuleNamestart = symbol.getStart();
    ModuleNameend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme ModuleName.
   * @return The value for the lexeme ModuleName.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ModuleName")
  public String getModuleName() {
    return tokenString_ModuleName != null ? tokenString_ModuleName : "";
  }
  /**
   * Replaces the lexeme FunName.
   * @param value The new value for the lexeme FunName.
   * @apilevel high-level
   */
  public Module setFunName(String value) {
    tokenString_FunName = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_FunName;
  /**
   */
  public int FunNamestart;
  /**
   */
  public int FunNameend;
  /**
   * JastAdd-internal setter for lexeme FunName using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FunName
   * @apilevel internal
   */
  public Module setFunName(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFunName is only valid for String lexemes");
    tokenString_FunName = (String)symbol.value;
    FunNamestart = symbol.getStart();
    FunNameend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme FunName.
   * @return The value for the lexeme FunName.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FunName")
  public String getFunName() {
    return tokenString_FunName != null ? tokenString_FunName : "";
  }
  /**
   * Replaces the Functions list.
   * @param list The new list node to be used as the Functions list.
   * @apilevel high-level
   */
  public Module setFunctionsList(List<Function> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Functions list.
   * @return Number of children in the Functions list.
   * @apilevel high-level
   */
  public int getNumFunctions() {
    return getFunctionsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Functions list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Functions list.
   * @apilevel low-level
   */
  public int getNumFunctionsNoTransform() {
    return getFunctionsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Functions list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Functions list.
   * @apilevel high-level
   */
  public Function getFunctions(int i) {
    return (Function) getFunctionsList().getChild(i);
  }
  /**
   * Check whether the Functions list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunctions() {
    return getFunctionsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Functions list.
   * @param node The element to append to the Functions list.
   * @apilevel high-level
   */
  public Module addFunctions(Function node) {
    List<Function> list = (parent == null) ? getFunctionsListNoTransform() : getFunctionsList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Module addFunctionsNoTransform(Function node) {
    List<Function> list = getFunctionsListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Functions list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Module setFunctions(Function node, int i) {
    List<Function> list = getFunctionsList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Functions list.
   * @return The node representing the Functions list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Functions")
  public List<Function> getFunctionsList() {
    List<Function> list = (List<Function>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Functions list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Functions list.
   * @apilevel low-level
   */
  public List<Function> getFunctionsListNoTransform() {
    return (List<Function>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Functions list without
   * triggering rewrites.
   */
  public Function getFunctionsNoTransform(int i) {
    return (Function) getFunctionsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Functions list.
   * @return The node representing the Functions list.
   * @apilevel high-level
   */
  public List<Function> getFunctionss() {
    return getFunctionsList();
  }
  /**
   * Retrieves the Functions list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Functions list.
   * @apilevel low-level
   */
  public List<Function> getFunctionssNoTransform() {
    return getFunctionsListNoTransform();
  }
/** @apilevel internal */
protected boolean addsIndentationLevel_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:48
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:46")
  public boolean addsIndentationLevel() {
    if (addsIndentationLevel_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.addsIndentationLevel().");
    }
    addsIndentationLevel_visited = true;
    boolean addsIndentationLevel_value = false;
    addsIndentationLevel_visited = false;
    return addsIndentationLevel_value;
  }
  /**
   * @attribute inh
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:73
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:73")
  public PrettyPrinter printer() {
    ASTState state = state();
    if (printer_computed) {
      return printer_value;
    }
    if (printer_visited) {
      throw new RuntimeException("Circular definition of attribute Module.printer().");
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
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:80
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFunctionsListNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:60
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
