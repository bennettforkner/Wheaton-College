# GuitarChords
A ‘Standard ML of New Jersey’ application that stores information on chords in a database with the ability to adjust and view the chords with user specifications.

Bennett Forkner
CSCI 243
Dr. VanDrunen
Guitar Chords Database
Write-Up

Problem Statement:
For years, students learning guitar have struggled to find the right chord library that tells them how to build chords and how to finger (position their fingers) them. iPhone apps confuse learners because they are not developed to be used in a command-line text-based application where it is easy to understand flat data.

Proposal:
The Bennett Forkner Software Development Team proposed a ‘Standard ML of New Jersey’ application that stores information on chords in a database with the ability to read chords and understand how to play them on a guitar.

Process:
In order to accomplish this the development team [of one] created a datatype, note, to store note values (C,D,E,F,etc & # & b[flat]) as well as decorators of those, chordNote, adding on placement of the notes on the guitar fretboard (using the software decorator pattern). The team also made the datatype chord which has a composition relationship of chordNotes. The class diagram can be seen below [pertaining to datatypes as classes].
The functions showFingering(chord) and getNotes(chord) are the main functionality of this program.

Limitations:
 This software does have its limitations as well. As such, it is unable to play the sound of chords so that users could know if they are playing them right. It is also not the easiest to read the fingering as a collection of characters, and would be better with a visual graphical interface.
Though this is true, the purpose of a model is to specifically focus on one aspect of something in order to capture how that part works alone. To that extent, this project succeeds in its goals.

Takeaways:
This project has given me a greater understanding of how Strings work in ML as the core of the code is centered around managing strings and concatenating them in certain ways. Since we did not do a lot with Strings in class, this was a good side study to ensure that I am understanding ML to completion.


□ the prosecution rests
