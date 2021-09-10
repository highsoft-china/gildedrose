export default function sum(a: any, b: any) {
  return a + b;
}

test('测试sum方法', () => {
  expect(sum(1, 2)).toBe(3);
});
