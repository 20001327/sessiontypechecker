/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.4-48-g8abc63a */
package miniErlang;
import miniErlang.Expression;
/**
 * @ast node
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\FErlangNew.ast:3
 * @astdecl Program : ASTNode ::= Modules:Module*;
 * @production Program : {@link ASTNode} ::= <span class="component">Modules:{@link Module}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    name = {"Modules"},
    type = {"List<Module>"},
    kind = {"List"}
  )
  public Program(List<Module> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    printer_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:61
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:91
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * Replaces the Modules list.
   * @param list The new list node to be used as the Modules list.
   * @apilevel high-level
   */
  public Program setModulesList(List<Module> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the Modules list.
   * @return Number of children in the Modules list.
   * @apilevel high-level
   */
  public int getNumModules() {
    return getModulesList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Modules list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Modules list.
   * @apilevel low-level
   */
  public int getNumModulesNoTransform() {
    return getModulesListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Modules list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Modules list.
   * @apilevel high-level
   */
  public Module getModules(int i) {
    return (Module) getModulesList().getChild(i);
  }
  /**
   * Check whether the Modules list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasModules() {
    return getModulesList().getNumChild() != 0;
  }
  /**
   * Append an element to the Modules list.
   * @param node The element to append to the Modules list.
   * @apilevel high-level
   */
  public Program addModules(Module node) {
    List<Module> list = (parent == null) ? getModulesListNoTransform() : getModulesList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Program addModulesNoTransform(Module node) {
    List<Module> list = getModulesListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Modules list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Program setModules(Module node, int i) {
    List<Module> list = getModulesList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Modules list.
   * @return The node representing the Modules list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Modules")
  public List<Module> getModulesList() {
    List<Module> list = (List<Module>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Modules list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Modules list.
   * @apilevel low-level
   */
  public List<Module> getModulesListNoTransform() {
    return (List<Module>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Modules list without
   * triggering rewrites.
   */
  public Module getModulesNoTransform(int i) {
    return (Module) getModulesListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Modules list.
   * @return The node representing the Modules list.
   * @apilevel high-level
   */
  public List<Module> getModuless() {
    return getModulesList();
  }
  /**
   * Retrieves the Modules list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Modules list.
   * @apilevel low-level
   */
  public List<Module> getModulessNoTransform() {
    return getModulesListNoTransform();
  }
/** @apilevel internal */
protected boolean addsIndentationLevel_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:47
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
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:55
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:55")
  public PrettyPrinter printer() {
    ASTState state = state();
    if (printer_computed) {
      return printer_value;
    }
    if (printer_visited) {
      throw new RuntimeException("Circular definition of attribute Program.printer().");
    }
    printer_visited = true;
    state().enterLazyAttribute();
    printer_value = printer_compute();
    printer_computed = true;
    state().leaveLazyAttribute();
    printer_visited = false;
    return printer_value;
  }
  /** @apilevel internal */
  private PrettyPrinter printer_compute() {
          return new PrettyPrinter();
      }
/** @apilevel internal */
protected boolean print_visited = false;
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:83
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:83")
  public PrettyPrinter print() {
    if (print_visited) {
      throw new RuntimeException("Circular definition of attribute Program.print().");
    }
    print_visited = true;
    try {
            printer().reset();
            for (Module module : getModuless()) module.print();
            return printer();
        }
    finally {
      print_visited = false;
    }
  }
  /**
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:80
   * @apilevel internal
   */
  public PrettyPrinter Define_printer(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getModulesListNoTransform()) {
      // @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:59
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
