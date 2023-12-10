var React = require('react');
var TodoItem = require('./TodoItem');

var TodoList = function(props) {
  var todoList = [];
  var todos = props.todos;
  for (var i = 0; i < todos.length; ++i) {
    todoList.push(<TodoItem todo={todos[i]} index={i} onDeleteBtnClick={props.onDeleteBtnClick} />);
  }

  return (
    <ul className="list-group">
      {todoList}
    </ul>
  );
};

module.exports = TodoList;
