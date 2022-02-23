/* Generated By:JavaCC: Do not edit this line. ExpressionParser.java */
package com.ogprover.pp.tp.expressions.parse;

import java.lang.String;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.ogprover.pp.tp.expressions.*;
import com.ogprover.pp.tp.geoconstruction.Point;
import com.ogprover.pp.tp.geoconstruction.FreePoint;

public class ExpressionParser implements ExpressionParserConstants {
  public static AMExpression convert(String arg) throws ParseException, TokenMgrError {
    InputStream input = new ByteArrayInputStream(arg.getBytes());
    ExpressionParser parser = new ExpressionParser(input);
    return parser.start();
  }

  final public AMExpression start() throws ParseException {
  AMExpression expr;
    if (jj_2_1(4217)) {
      expr = expression();
    } else if (jj_2_2(4217)) {
      expr = simpleSegment();
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return expr;}
    throw new Error("Missing return statement in function");
  }

  final public AMExpression expression() throws ParseException {
  AMExpression expr;
  AMExpression t;
    expr = term();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        t = term();
      expr = new Sum(expr, t);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        t = term();
      expr = new Difference(expr, t);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return expr;}
    throw new Error("Missing return statement in function");
  }

  final public AMExpression term() throws ParseException {
  AMExpression expr;
  AMExpression p;
    expr = primary();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEGMENT:
      case AREA:
      case MULTIPLY:
      case DIVIDE:
      case LEFTPAR:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        jj_consume_token(MULTIPLY);
        p = primary();
      expr = new Product(expr, p);
        break;
      case SEGMENT:
      case AREA:
      case LEFTPAR:
        p = notNumberPrimary();
      expr = new Product(expr, p);
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        p = primary();
          expr = new Fraction(expr, p);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return expr;}
    throw new Error("Missing return statement in function");
  }

  final public AMExpression primary() throws ParseException {
  Token t;
  AMExpression expr;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      t = jj_consume_token(NUMBER);
    {if (true) return new BasicNumber(Integer.parseInt(t.image));}
      break;
    case MINUS:
      jj_consume_token(MINUS);
      expr = primary();
    {if (true) return new AdditiveInverse(expr);}
      break;
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      expr = expression();
      jj_consume_token(RIGHTPAR);
    {if (true) return expr;}
      break;
    default:
      jj_la1[4] = jj_gen;
      if (jj_2_3(42)) {
        expr = ratioOfSegments();
    {if (true) return expr;}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AREA:
          expr = areaOfTriangle();
    {if (true) return expr;}
          break;
        default:
          jj_la1[5] = jj_gen;
          if (jj_2_4(42)) {
            expr = squareOfSegment();
    {if (true) return expr;}
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public AMExpression notNumberPrimary() throws ParseException {
  Token t;
  AMExpression expr;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      expr = expression();
      jj_consume_token(RIGHTPAR);
    {if (true) return expr;}
      break;
    default:
      jj_la1[6] = jj_gen;
      if (jj_2_5(42)) {
        expr = ratioOfSegments();
    {if (true) return expr;}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AREA:
          expr = areaOfTriangle();
    {if (true) return expr;}
          break;
        default:
          jj_la1[7] = jj_gen;
          if (jj_2_6(42)) {
            expr = squareOfSegment();
    {if (true) return expr;}
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public AMExpression ratioOfSegments() throws ParseException {
  Token s1, s2, s3, s4;
  Point pt1, pt2, pt3, pt4;
    jj_consume_token(SEGMENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFTBRACKET:
      jj_consume_token(LEFTBRACKET);
      break;
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    s1 = jj_consume_token(LABEL);
    jj_consume_token(COMMA);
    s2 = jj_consume_token(LABEL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      jj_consume_token(LABEL);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RIGHTBRACKET:
      jj_consume_token(RIGHTBRACKET);
      break;
    case RIGHTPAR:
      jj_consume_token(RIGHTPAR);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(DIVIDE);
    jj_consume_token(SEGMENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFTBRACKET:
      jj_consume_token(LEFTBRACKET);
      break;
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    s3 = jj_consume_token(LABEL);
    jj_consume_token(COMMA);
    s4 = jj_consume_token(LABEL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      jj_consume_token(LABEL);
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RIGHTBRACKET:
      jj_consume_token(RIGHTBRACKET);
      break;
    case RIGHTPAR:
      jj_consume_token(RIGHTPAR);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    pt1 = new FreePoint(s1.image);
    pt2 = new FreePoint(s2.image);
    pt3 = new FreePoint(s3.image);
    pt4 = new FreePoint(s4.image);
    {if (true) return new RatioOfCollinearSegments(pt1, pt2, pt3, pt4);}
    throw new Error("Missing return statement in function");
  }

  final public AMExpression areaOfTriangle() throws ParseException {
  Token s1, s2, s3;
  Point pt1, pt2, pt3;
    jj_consume_token(AREA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFTBRACKET:
      jj_consume_token(LEFTBRACKET);
      break;
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    s1 = jj_consume_token(LABEL);
    jj_consume_token(COMMA);
    s2 = jj_consume_token(LABEL);
    jj_consume_token(COMMA);
    s3 = jj_consume_token(LABEL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RIGHTBRACKET:
      jj_consume_token(RIGHTBRACKET);
      break;
    case RIGHTPAR:
      jj_consume_token(RIGHTPAR);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    pt1 = new FreePoint(s1.image);
    pt2 = new FreePoint(s2.image);
    pt3 = new FreePoint(s3.image);
    {if (true) return new AreaOfTriangle(pt1, pt2, pt3);}
    throw new Error("Missing return statement in function");
  }

  final public AMExpression squareOfSegment() throws ParseException {
  Token s1, s2;
  Point pt1, pt2;
    jj_consume_token(SEGMENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFTBRACKET:
      jj_consume_token(LEFTBRACKET);
      break;
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    s1 = jj_consume_token(LABEL);
    jj_consume_token(COMMA);
    s2 = jj_consume_token(LABEL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      jj_consume_token(LABEL);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RIGHTBRACKET:
      jj_consume_token(RIGHTBRACKET);
      break;
    case RIGHTPAR:
      jj_consume_token(RIGHTPAR);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(SQUARE);
    pt1 = new FreePoint(s1.image);
    pt2 = new FreePoint(s2.image);
    {if (true) return new Fraction(new PythagorasDifference(pt1, pt2, pt1), new BasicNumber (2));}
    throw new Error("Missing return statement in function");
  }

// This returns THE SQUARE of the segment.
// It is only used to compare two segments.
  final public AMExpression simpleSegment() throws ParseException {
  Token s1, s2;
  Point pt1, pt2;
    jj_consume_token(SEGMENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEFTBRACKET:
      jj_consume_token(LEFTBRACKET);
      break;
    case LEFTPAR:
      jj_consume_token(LEFTPAR);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    s1 = jj_consume_token(LABEL);
    jj_consume_token(COMMA);
    s2 = jj_consume_token(LABEL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      jj_consume_token(LABEL);
      break;
    default:
      jj_la1[20] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RIGHTBRACKET:
      jj_consume_token(RIGHTBRACKET);
      break;
    case RIGHTPAR:
      jj_consume_token(RIGHTPAR);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    pt1 = new FreePoint(s1.image);
    pt2 = new FreePoint(s2.image);
    {if (true) return new Fraction(new PythagorasDifference(pt1, pt2, pt1), new BasicNumber (2));}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_3R_23() {
    if (jj_scan_token(DIVIDE)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_24() {
    if (jj_scan_token(AREA)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) return true;
    }
    if (jj_scan_token(LABEL)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    xsp = jj_scanpos;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    return false;
  }

  private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_scan_token(MULTIPLY)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_7() {
    if (jj_3R_13()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_14()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    return false;
  }

  private boolean jj_3R_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) return true;
    }
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(PLUS)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    return false;
  }

  private boolean jj_3R_3() {
    if (jj_3R_7()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_8()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(SEGMENT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) return true;
    }
    if (jj_scan_token(LABEL)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    xsp = jj_scanpos;
    if (jj_3R_10()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    if (jj_scan_token(DIVIDE)) return true;
    if (jj_scan_token(SEGMENT)) return true;
    xsp = jj_scanpos;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) return true;
    }
    if (jj_scan_token(LABEL)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    xsp = jj_scanpos;
    if (jj_3R_11()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_3()) return true;
    return false;
  }

  private boolean jj_3_6() {
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3R_4() {
    if (jj_scan_token(SEGMENT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) return true;
    }
    if (jj_scan_token(LABEL)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    xsp = jj_scanpos;
    if (jj_3R_9()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(LEFTPAR)) return true;
    if (jj_3R_3()) return true;
    if (jj_scan_token(RIGHTPAR)) return true;
    return false;
  }

  private boolean jj_3R_25() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3_6()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_scan_token(LEFTPAR)) return true;
    if (jj_3R_3()) return true;
    if (jj_scan_token(RIGHTPAR)) return true;
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_scan_token(SEGMENT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) return true;
    }
    if (jj_scan_token(LABEL)) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(LABEL)) return true;
    xsp = jj_scanpos;
    if (jj_3R_12()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(21)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    if (jj_scan_token(SQUARE)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3_4()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public ExpressionParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x300,0x300,0x40c60,0x40c60,0x41200,0x40,0x40000,0x40,0x140000,0x400000,0x280000,0x140000,0x400000,0x280000,0x140000,0x280000,0x140000,0x400000,0x280000,0x140000,0x400000,0x280000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[6];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public ExpressionParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ExpressionParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ExpressionParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public ExpressionParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ExpressionParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public ExpressionParser(ExpressionParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ExpressionParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[23];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 23; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 6; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
