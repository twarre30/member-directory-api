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
    2000,
    'Jane',
    'Brenda',
    '567 Main St',
    'jane@gmail.com',
    '555-451-2575'
  );