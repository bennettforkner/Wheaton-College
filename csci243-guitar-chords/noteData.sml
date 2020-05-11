(*
* noteData.sml
*
* File to store base-level information about musical notes
*
* by
* Bennett Forkner
*
* Submitted in partial requirement for completion of the CSCI 243 Course at
* Wheaton College (IL)
*
* *)

val x = note(#"X",false,false); (* for muted strings *)

(* Regular Notes *)
val c = note(#"c",false,false);
val d = note(#"d",false,false);
val e = note(#"e",false,false);
val f = note(#"f",false,false);
val g = note(#"g",false,false);
val a = note(#"a",false,false);
val b = note(#"b",false,false);

(* Sharps *)
val csh = note(#"c",true,false);
val dsh = note(#"d",true,false);
val esh = note(#"e",true,false); (* aka f *)
val fsh = note(#"f",true,false);
val gsh = note(#"g",true,false);
val ash = note(#"a",true,false);
val bsh = note(#"b",true,false); (* aka c *)

(* flats *)
val cfl = note(#"c",false,true); (* aka b *)
val dfl = note(#"d",false,true);
val efl = note(#"e",false,true);
val ffl = note(#"f",false,true); (* aka e *)
val gfl = note(#"g",false,true);
val afl = note(#"a",false,true);
val bfl = note(#"b",false,true);
