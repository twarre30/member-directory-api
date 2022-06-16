TRUNCATE TABLE member;

INSERT INTO
  member(
    id,
    parent_name,
    daughter_name,
    address,
    email,
    phone_number
  )
VALUES
  (
    1000,
    'Mary',
    'Suzy',
    '123 Main St',
    'mary@gmail.com',
    '555 -253 -4512'
  ),
  (
    1001,
    'Jane',
    'Brenda',
    '567 Main St',
    'jane@gmail.com',
    '555-451-2575'
  ),
(
    1002,
    'John',
    'Tracey',
    '789 Main St',
    'john@aol.com',
    '555-555-2175'
  ),
(
    1003,
    'Juliet',
    'Daisy',
    '8456 Girl Scout Lane',
    'jlowe@yahoo.com',
    '555-859-7585'
  );