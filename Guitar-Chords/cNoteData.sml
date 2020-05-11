
(*
* cNoteData.sml
*
* File to store information about chord notes (notes with an adapter of extra
* data (with a specific placement on the fretboard))
*
* by
* Bennett Forkner
*
* Submitted in partial requirement for completion of the CSCI 243 course at
* Wheaton College (IL)
*
* *)

val X = cNote(x,#"X",0); (* for muted strings *)

(* low E string notes *)
val E0 = cNote(e,#"E",0);
val E1 = cNote(f,#"E",1);
val E2 = cNote(fsh,#"E",2);
val E3 = cNote(g,#"E",3);
val E4 = cNote(gsh,#"E",4);
val E5 = cNote(a,#"E",5);
val E6 = cNote(ash,#"E",6);
val E7 = cNote(b,#"E",7);
val E8 = cNote(c,#"E",8);
val E9 = cNote(csh,#"E",9);
val E10 = cNote(d,#"E",10);
val E11 = cNote(dsh,#"E",11);
val E12 = cNote(e,#"E",12);
val E13 = cNote(f,#"E",13);
val E14 = cNote(fsh,#"E",14);
val E15 = cNote(g,#"E",15);

(* A string notes *)
val A0 = cNote(a,#"A",0);
val A1 = cNote(ash,#"A",1);
val A2 = cNote(b,#"A",2);
val A3 = cNote(c,#"A",3);
val A4 = cNote(csh,#"A",4);
val A5 = cNote(d,#"A",5);
val A6 = cNote(dsh,#"A",6);
val A7 = cNote(e,#"A",7);
val A8 = cNote(f,#"A",8);
val A9 = cNote(fsh,#"A",9);
val A10 = cNote(g,#"A",10);
val A11 = cNote(gsh,#"A",11);
val A12 = cNote(a,#"A",12);
val A13 = cNote(ash,#"A",13);
val A14 = cNote(b,#"A",14);
val A15 = cNote(c,#"A",15);

(* D string notes *)
val D0 = cNote(d,#"D",0);
val D1 = cNote(dsh,#"D",1);
val D2 = cNote(e,#"D",2);
val D3 = cNote(f,#"D",3);
val D4 = cNote(fsh,#"D",4);
val D5 = cNote(g,#"D",5);
val D6 = cNote(gsh,#"D",6);
val D7 = cNote(a,#"D",7);
val D8 = cNote(ash,#"D",8);
val D9 = cNote(b,#"D",9);
val D10 = cNote(c,#"D",10);
val D11 = cNote(csh,#"D",11);
val D12 = cNote(d,#"D",12);
val D13 = cNote(dsh,#"D",13);
val D14 = cNote(e,#"D",14);
val D15 = cNote(f,#"D",15);

(* G string notes *)
val G0 = cNote(g,#"G",0);
val G1 = cNote(gsh,#"G",1);
val G2 = cNote(a,#"G",2);
val G3 = cNote(ash,#"G",3);
val G4 = cNote(b,#"G",4);
val G5 = cNote(c,#"G",5);
val G6 = cNote(csh,#"G",6);
val G7 = cNote(d,#"G",7);
val G8 = cNote(dsh,#"G",8);
val G9 = cNote(e,#"G",9);
val G10 = cNote(f,#"G",10);
val G11 = cNote(fsh,#"G",11);
val G12 = cNote(g,#"G",12);
val G13 = cNote(gsh,#"G",13);
val G14 = cNote(a,#"G",14);
val G15 = cNote(ash,#"G",15);

(* B string notes *)
val B0 = cNote(b,#"B",0);
val B1 = cNote(c,#"B",1);
val B2 = cNote(csh,#"B",2);
val B3 = cNote(d,#"B",3);
val B4 = cNote(dsh,#"B",4);
val B5 = cNote(e,#"B",5);
val B6 = cNote(f,#"B",6);
val B7 = cNote(fsh,#"B",7);
val B8 = cNote(g,#"B",8);
val B9 = cNote(gsh,#"B",9);
val B10 = cNote(a,#"B",10);
val B11 = cNote(ash,#"B",11);
val B12 = cNote(b,#"B",12);
val B13 = cNote(c,#"B",13);
val B14 = cNote(csh,#"B",14);
val B15 = cNote(d,#"B",15);

(* high e string notes *)
val e0 = cNote(e,#"e",0);
val e1 = cNote(f,#"e",1);
val e2 = cNote(fsh,#"e",2);
val e3 = cNote(g,#"e",3);
val e4 = cNote(gsh,#"e",4);
val e5 = cNote(a,#"e",5);
val e6 = cNote(ash,#"e",6);
val e7 = cNote(b,#"e",7);
val e8 = cNote(c,#"e",8);
val e9 = cNote(csh,#"e",9);
val e10 = cNote(d,#"e",10);
val e11 = cNote(dsh,#"e",11);
val e12 = cNote(e,#"e",12);
val e13 = cNote(f,#"e",13);
val e14 = cNote(fsh,#"e",14);
val e15 = cNote(g,#"e",15);
