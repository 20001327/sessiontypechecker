package miniErlang;

import miniErlang.Expression;
/**
 * @ast class
 * @aspect PrettyPrint
 * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:5
 */
public class PrettyPrinter extends java.lang.Object {
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:6
   */
  
        public static String INDENT = "  ";
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:7
   */
  
        private StringBuilder sb;
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:9
   */
  

        public PrettyPrinter() {
            sb = new StringBuilder();
        }
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:13
   */
  

        public void append(String s) {
            sb.append(s);
        }
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:17
   */
  

        public String getString() {
            return sb.toString();
        }
  /**
   * @aspect PrettyPrint
   * @declaredat C:\\Users\\Lorenzo\\IdeaProjects\\TwoBuyerProtocol\\spec\\PrettyPrint.jrag:21
   */
  

        public void reset() {
            sb.setLength(0);
        }

}
