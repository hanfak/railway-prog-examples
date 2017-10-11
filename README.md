# Business Flows Example

Examples of using a java libray implementing 'Railway programming'.

The libray being used is **Business Flows** found here https://github.com/theangrydev/business-flows

See here for more info on Railway programing: https://fsharpforfunandprofit.com/rop/

## Examples:

- Chaining in a functional style, to flow through happy and sad path, and deal with exceptions via technical failures.
  - To see examples being run, run main method here *railway-prog-examples/src/main/java/examplerunners/JobApplicationProcessRunner.java*
- Using Potential failures, to handle sad path only cases where happy path is not neccesary and only care about the sad path.
  - To see examples being run, run main method here *railway-prog-examples/src/main/java/examplerunners/FiringProcessRunner.java*
- Using Happy Path, when need to use both paths to split flow and do next steps.
  - To see examples being run, run main method here *railway-prog-examples/src/main/java/examplerunners/SalaryProcessRunner.java*


