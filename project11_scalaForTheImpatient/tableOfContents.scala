
Table of Contents

Foreword xvii

Preface xix

About the Author xxi

 

Chapter 1: The Basics 1

1.1 The Scala Interpreter 1

1.2 Declaring Values and Variables 3

1.3 Commonly Used Types 4

1.4 Arithmetic and Operator Overloading 5

1.5 Calling Functions and Methods 7

1.6 The apply Method 8

1.7 Scaladoc 8

Exercises 11

Chapter 2: Control Structures and Functions 13

2.1 Conditional Expressions 14

2.2 Statement Termination 15

2.3 Block Expressions and Assignments 16

2.4 Input and Output 17

2.5 Loops 18

2.6 Advanced for Loops and for Comprehensions 19

2.7 Functions 20

2.8 Default and Named Arguments 21

2.9 Variable Arguments 22

2.10 Procedures 23

2.11 Lazy Values 23

2.12 Exceptions 24

Exercises 26

Chapter 3: Working with Arrays 29

3.1 Fixed-Length Arrays 29

3.2 Variable-Length Arrays: Array Buffers 30

3.3 Traversing Arrays and Array Buffers 31

3.4 Transforming Arrays 32

3.5 Common Algorithms 34

3.6 Deciphering Scaladoc 35

3.7 Multidimensional Arrays 37

3.8 Interoperating with Java 37

Exercises 38

Chapter 4: Maps and Tuples 41

4.1 Constructing a Map 41

4.2 Accessing Map Values 42

4.3 Updating Map Values 43

4.4 Iterating over Maps 43

4.5 Sorted Maps 44

4.6 Interoperating with Java 44

4.7 Tuples 45

4.8 Zipping 46

Exercises 46

Chapter 5: Classes 49

5.1 Simple Classes and Parameterless Methods 49

5.2 Properties with Getters and Setters 50

5.3 Properties with Only Getters 53

5.4 Object-Private Fields 54

5.5 Bean Properties 55

5.6 Auxiliary Constructors 56

5.7 The Primary Constructor 57

5.8 Nested Classes 60

Exercises 63

Chapter 6: Objects 65

6.1 Singletons 65

6.2 Companion Objects 66

6.3 Objects Extending a Class or Trait 67

6.4 The apply Method 67

6.5 Application Objects 68

6.6 Enumerations 69

Exercises 71

Chapter 7: Packages and Imports 73

7.1 Packages 74

7.2 Scope Rules 75

7.3 Chained Package Clauses 77

7.4 Top-of-File Notation 77

7.5 Package Objects 78

7.6 Package Visibility 78

7.7 Imports 79

7.8 Imports Can Be Anywhere 80

7.9 Renaming and Hiding Members 80

7.10 Implicit Imports 80

Exercises 81

Chapter 8: Inheritance 85

8.1 Extending a Class 85

8.2 Overriding Methods 86

8.3 Type Checks and Casts 87

8.4 Protected Fields and Methods 88

8.5 Superclass Construction 88

8.6 Overriding Fields 89

8.7 Anonymous Subclasses 91

8.8 Abstract Classes 91

8.9 Abstract Fields 91

8.10 Construction Order and Early Definitions 92

8.11 The Scala Inheritance Hierarchy 94

8.12 Object Equality 95

Exercises 96

Chapter 9: Files and Regular Expressions 99

9.1 Reading Lines 100

9.2 Reading Characters 100

9.3 Reading Tokens and Numbers 101

9.4 Reading from URLs and Other Sources 102

9.5 Reading Binary Files 102

9.6 Writing Text Files 102

9.7 Visiting Directories 103

9.8 Serialization 104

9.9 Process Control 105

9.10 Regular Expressions 106

9.11 Regular Expression Groups 107

Exercises 107

Chapter 10: Traits 111

10.1 Why No Multiple Inheritance? 111

10.2 Traits as Interfaces 113

10.3 Traits with Concrete Implementations 114

10.4 Objects with Traits 115

10.5 Layered Traits 116

10.6 Overriding Abstract Methods in Traits 117

10.7 Traits for Rich Interfaces 118

10.8 Concrete Fields in Traits 118

10.9 Abstract Fields in Traits 119

10.10 Trait Construction Order 120

10.11 Initializing Trait Fields 122

10.12 Traits Extending Classes 123

10.13 Self Types 124

10.14 What Happens under the Hood 125

Exercises 127

Chapter 11: Operators 131

11.1 Identifiers 131

11.2 Infix Operators 132

11.3 Unary Operators 133

11.4 Assignment Operators 133

11.5 Precedence 134

11.6 Associativity 135

11.7 The apply and update Methods 135

11.8 Extractors 136

11.9 Extractors with One or No Arguments 138

11.10 The unapplySeq Method 138

Exercises 139

Chapter 12: Higher-Order Functions 143

12.1 Functions as Values 143

12.2 Anonymous Functions 144

12.3 Functions with Function Parameters 145

12.4 Parameter Inference 146

12.5 Useful Higher-Order Functions 146

12.6 Closures 148

12.7 SAM Conversions 149

12.8 Currying 149

12.9 Control Abstractions 150

12.10 The return Expression 152

Exercises 152

Chapter 13: Collections 155

13.1 The Main Collections Traits 156

13.2 Mutable and Immutable Collections 157

13.3 Sequences 158

13.4 Lists 159

13.5 Mutable Lists 160

13.6 Sets 161

13.7 Operators for Adding or Removing Elements 162

13.8 Common Methods 164

13.9 Mapping a Function 167

13.10 Reducing, Folding, and Scanning 168

13.11 Zipping 171

13.12 Iterators 172

13.13 Streams 173

13.14 Lazy Views 174

13.15 Interoperability with Java Collections 175

13.16 Threadsafe Collections 177

13.17 Parallel Collections 178

Exercises 179

Chapter 14: Pattern Matching and Case Classes 183

14.1 A Better Switch 184

14.2 Guards 185

14.3 Variables in Patterns 185

14.4 Type Patterns 186

14.5 Matching Arrays, Lists, and Tuples 187

14.6 Extractors 188

14.7 Patterns in Variable Declarations 188

14.8 Patterns in for Expressions 189

14.9 Case Classes 189

14.10 The copy Method and Named Parameters 190

14.11 Infix Notation in case Clauses 191

14.12 Matching Nested Structures 192

14.13 Are Case Classes Evil? 192

14.14 Sealed Classes 193

14.15 Simulating Enumerations 194

14.16 The Option Type 194

14.17 Partial Functions 195

Exercises 196

Chapter 15: Annotations 199

15.1 What Are Annotations? 200

15.2 What Can Be Annotated? 200

15.3 Annotation Arguments 201

15.4 Annotation Implementations 202

15.5 Annotations for Java Features 203

15.6 Annotations for Optimizations 206

15.7 Annotations for Errors and Warnings 210

Exercises 211

Chapter 16: XML Processing 213

16.1 XML Literals 214

16.2 XML Nodes 214

16.3 Element Attributes 216

16.4 Embedded Expressions 217

16.5 Expressions in Attributes 218

16.6 Uncommon Node Types 219

16.7 XPath-like Expressions 220

16.8 Pattern Matching 221

16.9 Modifying Elements and Attributes 222

16.10 Transforming XML 223

16.11 Loading and Saving 223

16.12 Namespaces 226

Exercises 227

Chapter 17: Type Parameters 231

17.1 Generic Classes 232

17.2 Generic Functions 232

17.3 Bounds for Type Variables 232

17.4 View Bounds 234

17.5 Context Bounds 234

17.6 The Manifest Context Bound 235

17.7 Multiple Bounds 235

17.8 Type Constraints 236

17.9 Variance 237

17.10 Co- and Contravariant Positions 238

17.11 Objects Can’t Be Generic 240

17.12 Wildcards 241

Exercises 241

Chapter 18: Advanced Types 245

18.1 Singleton Types 246

18.2 Type Projections 247

18.3 Paths 248

18.4 Type Aliases 249

18.5 Structural Types 250

18.6 Compound Types 250

18.7 Infix Types 251

18.8 Existential Types 252

18.9 The Scala Type System 253

18.10 Self Types 254

18.11 Dependency Injection 255

18.12 Abstract Types 257

18.13 Family Polymorphism 259

18.14 Higher-Kinded Types 263

Exercises 265

Chapter 19: Parsing 269

19.1 Grammars 270

19.2 Combining Parser Operations 271

19.3 Transforming Parser Results 273

19.4 Discarding Tokens 274

19.5 Generating Parse Trees 275

19.6 Avoiding Left Recursion 276

19.7 More Combinators 277

19.8 Avoiding Backtracking 280

19.9 Packrat Parsers 280

19.10 What Exactly Are Parsers? 281

19.11 Regex Parsers 282

19.12 Token-Based Parsers 283

19.13 Error Handling 285

Exercises 286

Chapter 20: Actors 289

20.1 Creating and Starting Actors 290

20.2 Sending Messages 291

20.3 Receiving Messages 292

20.4 Sending Messages to Other Actors 293

20.5 Channels 294

20.6 Synchronous Messages and Futures 295

20.7 Thread Sharing 296

20.8 The Actor Life Cycle 299

20.9 Linking Actors 300

20.10 Designing with Actors 301

Exercises 302

Chapter 21: Implicits 305

21.1 Implicit Conversions 306

21.2 Using Implicits for Enriching Existing Libraries 306

21.3 Importing Implicits 307

21.4 Rules for Implicit Conversions 308

21.5 Implicit Parameters 309

21.6 Implicit Conversions with Implicit Parameters 310

21.7 Context Bounds 311

21.8 Evidence 312

21.9 The @implicitNotFound Annotation 313

21.10 CanBuildFrom Demystified 314

Exercises 316

Chapter 22: Delimited Continuations 319

22.1 Capturing and Invoking a Continuation 320

22.2 The “Computation with a Hole” 321

22.3 The Control Flow of reset and shift 322

22.4 The Value of a reset Expression 323

22.5 The Types of reset and shift Expressions 323

22.6 CPS Annotations 325

22.7 Turning a Recursive Visit into an Iteration 326

22.8 Undoing Inversion of Control 329

22.9 The CPS Transformation 332

22.10 Transforming Nested Control Contexts 334

Exercises 336

Index 339