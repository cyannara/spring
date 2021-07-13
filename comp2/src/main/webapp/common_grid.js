/**
 * 
 */

 class MyCheckboxRenderer {
	  constructor(props) {
	    const el = document.createElement('input');
	    const { grid, rowKey, columnInfo } = props;

	    el.type = 'checkbox';
	    el.addEventListener('input', () => {
	      grid.setValue(rowKey, columnInfo.name, el.value);
	    });

	    this.el = el;
	    this.render(props);
	  }

	  getElement() {
	    return this.el;
	  }

	  getValue() {
	    return this.el.value;
	  }

	  render(props) {
	    this.el.value = String(props.value);
	  }
	}