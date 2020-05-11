
(*
* GuitarChords.sml
*
* Code to present functionality for project to adjust and present stored data
*
* by
* Bennett Forkner
* 2019
*
* Submitted in partial requirement for completion of the CSCI 243 course at Wheaton College
* (IL)
* *)

datatype Note = note of (char * bool * bool) (*note/sharp/flat*);



datatype ChordNote = cNote of (Note * char * int) (*noteValue/stringName/fret*)
(*(“E”, “a”, “d”, “g”, “b”, “e”) for strings*)

datatype Chord = chord of (ChordNote * ChordNote * ChordNote * ChordNote *
     ChordNote * ChordNote);

fun getNoteName(note(n,s,f)) = implode([n]) ^ (if s then "#" else "") ^ (if f then "♭" else
  "");

fun getCNoteName(cNote(n,x,y)) = getNoteName(n);


(*fix repeated notes in getNotes function*)
fun contains(x,[]) = false
| contains(x, y::rest) = if x = y then true else contains(x,rest);

fun makeNoRepeats2([],noRep) = noRep
| makeNoRepeats2(a::rest,noRep) = if contains(a,noRep) then
  makeNoRepeats2(rest,noRep) else makeNoRepeats2(rest,a::noRep);

fun makeNoRepeats(aList) = makeNoRepeats2(aList,[]);




fun getNotes(chord(string1,string2,string3,string4,string5,string6)) =
  makeNoRepeats([getCNoteName(string1),getCNoteName(string2),getCNoteName(string3),getCNoteName(string4),getCNoteName(string5),getCNoteName(string6)]);

fun showFingeringOneString(cNote(x,y,z)) =
        (if (z = 0) then "*|" else "-|") ^
        (if (z = 1) then "-*-|" else "---|") ^
        (if (z = 2) then "-*-|" else "---|") ^
        (if (z = 3) then "-*-|" else "---|") ^
        (if (z = 4) then "-*-|" else "---|") ^
        (if (z = 5) then "-*-|" else "---|") ^
        (if (z = 6) then "-*-|" else "---|") ^
        (if (z = 7) then "-*-|" else "---|") ^
        (if (z = 8) then "-*-|" else "---|") ^
        (if (z = 9) then "-*-|" else "---|") ^
        (if (z = 10) then "-*-|" else "---|") ^
        (if (z = 11) then "-*-|" else "---|") ^
        (if (z = 12) then "-*-|" else "---|") ^
        (if (z = 13) then "-*-|" else "---|") ^
        (if (z = 14) then "-*-|" else "---|") ^
        (if (z = 15) then "-*-|" else "---|");

fun
  showFingering(chord(string1,string2,string3,string4,string5,string6)) =
  print(
  "\n" ^ "\n" ^
  "   0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15" ^
  "\n" ^
  "e: " ^ showFingeringOneString(string6) ^
  "\n" ^
  "B: " ^ showFingeringOneString(string5) ^
  "\n" ^
  "G: " ^ showFingeringOneString(string4) ^
  "\n" ^
  "D: " ^ showFingeringOneString(string3) ^
  "\n" ^
  "A: " ^ showFingeringOneString(string2) ^
  "\n" ^
  "E: " ^ showFingeringOneString(string1) ^
  "\n" ^ "\n" ^ "\n"
);
