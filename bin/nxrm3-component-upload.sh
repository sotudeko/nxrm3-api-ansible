#!/bin/bash

playbook=nxrm3-component-upload

ansible-playbook -v ../playbooks/${playbook}.yml --extra-vars @data/component.json



